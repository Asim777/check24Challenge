package com.asimgasimzade.check24challenge.presentation.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.asimgasimzade.check24challenge.BR
import com.asimgasimzade.check24challenge.R
import com.asimgasimzade.check24challenge.presentation.base.BindableAdapter
import com.asimgasimzade.check24challenge.presentation.model.ProductUiModel
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

class ProductsAdapter() :
    RecyclerView.Adapter<ProductsAdapter.ProductHolder>(),
    BindableAdapter<List<ProductUiModel>> {

    private val subscriptions = CompositeDisposable()

    var products = mutableListOf<ProductUiModel>()
    val itemClick = PublishSubject.create<Int>()

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        subscriptions.clear()
    }

    override fun setData(data: List<ProductUiModel>) {
        products = data.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.product_item,
                null,
                false
            )
        )

    override fun getItemCount() = products.size + 1

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        RxView.clicks(holder.itemView)
            .subscribe {
                itemClick.onNext(position)
            }.addTo(subscriptions)

        holder.bind(products[position])
    }

    inner class ProductHolder(
        private val viewDataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(productItem: ProductUiModel) {
            viewDataBinding.setVariable(BR.productUiModel, productItem)
        }
    }
}
