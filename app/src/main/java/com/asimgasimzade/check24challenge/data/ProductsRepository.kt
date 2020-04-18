package com.asimgasimzade.check24challenge.data

import com.asimgasimzade.check24challenge.domain.ProductListResponse
import io.reactivex.Single

interface ProductsRepositoryType {
    fun get(): Single<ProductListResponse>
}

class ProductsRepository(
    private val dataSource: ProductsDataSource
) : ProductsRepositoryType {
    override fun get() = dataSource.get()
}