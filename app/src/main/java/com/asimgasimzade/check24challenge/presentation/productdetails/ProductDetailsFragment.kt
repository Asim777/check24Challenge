package com.asimgasimzade.check24challenge.presentation.productdetails

import androidx.lifecycle.ViewModelProviders
import com.asimgasimzade.check24challenge.R
import com.asimgasimzade.check24challenge.databinding.FragmentProductDetailsBinding
import com.asimgasimzade.check24challenge.presentation.base.BaseFragment

class ProductDetailsFragment : BaseFragment<ProductDetailsViewModel, FragmentProductDetailsBinding>() {

    override fun onResume() {
        super.onResume()
        setupInputListeners()
        setupOutputListeners()
        setupUi()
    }

    private fun setupUi() {

    }

    private fun setupOutputListeners() {
        //TODO: Implement output listeners
    }

    private fun setupInputListeners() {
        //TODO: Implement input listeners
    }

    override val bindingLayout: Int = R.layout.fragment_product_details
    override val viewModel: ProductDetailsViewModel by lazy {
        ViewModelProviders.of(this, vmFactory).get(ProductDetailsViewModel::class.java)
    }
}