package com.asimgasimzade.check24challenge.presentation.model

import com.asimgasimzade.check24challenge.presentation.base.BaseMapper
import com.asimgasimzade.check24challenge.domain.Product
import dagger.Reusable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.math.round

@Reusable
class ProductResponseToUiMapper @Inject constructor() : BaseMapper<Product, ProductUiModel>() {
    override fun map(from: Product): ProductUiModel{
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val friendlyDate = dateFormat.format(Date(from.releaseDate))
        val denominator = 2;
        val roundedRating = (round(from.rating * denominator) / denominator).toFloat()

        return ProductUiModel(
            name = from.name,
            type = from.type,
            id = from.id,
            color = from.color,
            imageURL = from.imageURL,
            colorCode = from.colorCode,
            available = from.available,
            releaseDate = friendlyDate,
            description = from.description,
            longDescription = from.longDescription,
            rating = roundedRating,
            price = (from.price).let {
                PriceUiModel(
                    it.value,
                    it.currency
                )
            }
        )
    }
}