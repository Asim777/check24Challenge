package com.asimgasimzade.check24challenge.usecases

import com.asimgasimzade.check24challenge.data.ProductsRepositoryType
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetProducts @Inject constructor(
    private val productsRepository: ProductsRepositoryType
) {
    //TODO: Map response model to ui model
    fun execute() = productsRepository.get()
}
