package com.asimgasimzade.check24challenge.framework

import com.asimgasimzade.check24challenge.framework.di.ServiceProvider
import com.asimgasimzade.check24challenge.domain.ProductListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers(CONTENT_TYPE_JSON)
    @GET("products-test.json")
    fun getProducts(): Single<ProductListResponse>

    companion object {
        const val CONTENT_TYPE_JSON = "content-type: application/json"
    }
}

interface ApiServiceProvider : ServiceProvider<ApiService>