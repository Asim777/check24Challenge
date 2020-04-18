package com.asimgasimzade.check24challenge.presentation.productlist

import android.app.Application
import com.asimgasimzade.check24challenge.framework.SchedulerProvider
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModel
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModelInputs
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModelOutputs
import com.asimgasimzade.check24challenge.presentation.model.ProductListResponseToUiMapper
import com.asimgasimzade.check24challenge.presentation.model.ProductListUiModel
import com.asimgasimzade.check24challenge.usecases.GetProducts
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

interface ProductListViewModelInputs : BaseViewModelInputs {}

interface ProductListViewModelOutputs : BaseViewModelOutputs {
    fun setupUi(): Observable<ProductListUiModel>
}

class ProductListViewModel @Inject constructor(
    private val getProducts: GetProducts,
    private val productListResponseToUiMapper: ProductListResponseToUiMapper,
    application: Application,
    schedulerProvider: SchedulerProvider
) : BaseViewModel(application, schedulerProvider),
    ProductListViewModelInputs,
    ProductListViewModelOutputs {

    override val inputs: ProductListViewModelInputs
        get() = this

    override val outputs: ProductListViewModelOutputs
        get() = this

    private val setupUi = PublishSubject.create<ProductListUiModel>()

    override fun onResume() {
        getProducts.execute()
            .compose(schedulerProvider.doOnIoObserveOnMainSingle())
            .subscribe({
                val responseUi = productListResponseToUiMapper.map(it)
                setupUi.onNext(responseUi)
            }, {
                //TODO: Handle error with showing error view
            }).addTo(subscriptions)
    }

    override fun setupUi(): Observable<ProductListUiModel> = setupUi.observeOnUiAndHide()
}