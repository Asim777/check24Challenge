package com.asimgasimzade.check24challenge.presentation.productdetails

import android.app.Application
import com.asimgasimzade.check24challenge.framework.SchedulerProvider
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModel
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModelInputs
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModelOutputs
import javax.inject.Inject

interface ProductDetailsViewModelInputs : BaseViewModelInputs {}

interface ProductDetailsViewModelOutputs : BaseViewModelOutputs {}

class ProductDetailsViewModel @Inject constructor(
    application: Application,
    schedulerProvider: SchedulerProvider
) : BaseViewModel(application, schedulerProvider),
    ProductDetailsViewModelInputs,
    ProductDetailsViewModelOutputs {

    override val inputs: ProductDetailsViewModelInputs
        get() = this

    override val outputs: ProductDetailsViewModelOutputs
        get() = this
}