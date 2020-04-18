package com.asimgasimzade.check24challenge.framework.remote

import com.asimgasimzade.check24challenge.framework.ApiServiceProvider
import com.asimgasimzade.check24challenge.data.ProductsDataSource
import dagger.Reusable
import javax.inject.Inject

class RemoteProductsDataSource @Inject constructor(
    private val apiServiceProvider: ApiServiceProvider
) : ProductsDataSource {
    private val apiService by lazy { apiServiceProvider.getInstance() }

    override fun get() = apiService.getProducts()
}