package com.asimgasimzade.check24challenge.domain

data class ProductListResponse(
    val header: ProductListHeader,
    val filters: List<String>,
    val products: List<Product>
)
