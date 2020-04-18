package com.asimgasimzade.check24challenge.presentation.model

import com.asimgasimzade.check24challenge.presentation.base.BaseMapper
import com.asimgasimzade.check24challenge.domain.ProductListResponse
import dagger.Reusable
import javax.inject.Inject

@Reusable
class ProductListResponseToUiMapper @Inject constructor(
    private val productResponseToUiMapper: ProductResponseToUiMapper
): BaseMapper<ProductListResponse, ProductListUiModel>() {
    override fun map(from: ProductListResponse) = ProductListUiModel(
        header = from.header,
        filters = from.filters,
        products = from.products.map(productResponseToUiMapper::map)
    )
}