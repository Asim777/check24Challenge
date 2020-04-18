package com.asimgasimzade.check24challenge.presentation.model

import com.asimgasimzade.check24challenge.domain.ProductListHeader

data class ProductListUiModel(
    val header: ProductListHeader,
    val filters: List<String>,
    val products: List<ProductUiModel>
)

data class ProductListHeader(
    val headerTitle: String,
    val headerDescription: String
)