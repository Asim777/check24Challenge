package com.asimgasimzade.check24challenge.presentation.model

data class ProductUiModel(
    val name: String,
    val type: String,
    val id: Int,
    val color: String,
    val imageURL: String,
    val colorCode: String,
    val available: Boolean,
    val releaseDate: String,
    val description: String,
    val longDescription: String,
    val rating: Float,
    val price: PriceUiModel
)

data class PriceUiModel(
    val value: Double,
    val currency: String
)