package com.asimgasimzade.check24challenge.presentation.productlist

import androidx.lifecycle.ViewModelProviders
import com.asimgasimzade.check24challenge.R
import com.asimgasimzade.check24challenge.BR
import com.asimgasimzade.check24challenge.databinding.FragmentProductListBinding
import com.asimgasimzade.check24challenge.presentation.base.BaseFragment
import com.asimgasimzade.check24challenge.presentation.model.ProductListUiModel
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : BaseFragment<ProductListViewModel, FragmentProductListBinding>() {

    override fun onResume() {
        super.onResume()
        setupInputListeners()
        setupOutputListeners()
        viewModel.onResume()
    }

    private fun setupOutputListeners() {
        viewModel.outputs.setupUi()
            .subscribe(::setupUi)
            .addTo(subscriptions)
    }

    private fun setupInputListeners() {
        //TODO: Implement input listeners
    }

    private fun setupUi(productListUiModel: ProductListUiModel) {
        productsRecyclerView.adapter = ProductsAdapter()
        binding.setVariable(BR.productListUiModel, productListUiModel)

    }

    override val bindingLayout: Int = R.layout.fragment_product_list
    override val viewModel: ProductListViewModel by lazy {
        ViewModelProviders.of(this, vmFactory).get(ProductListViewModel::class.java)
    }
}