package com.asimgasimzade.check24challenge.data

import com.asimgasimzade.check24challenge.domain.ProductListResponse
import dagger.Reusable
import io.reactivex.Single

@Reusable
interface ProductsDataSource {
    fun get(): Single<ProductListResponse>
}