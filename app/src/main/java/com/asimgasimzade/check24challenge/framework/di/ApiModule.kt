package com.asimgasimzade.check24challenge.framework.di

import com.asimgasimzade.check24challenge.BuildConfig
import com.asimgasimzade.check24challenge.framework.ApiService
import com.asimgasimzade.check24challenge.framework.ApiServiceProvider
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

const val RETROFIT_PROVIDER = "retrofit"
const val BASE_URL_PROVIDER = "base_url"
const val HTTP_BUILDER = "http_builder"
const val HTTP_CLIENT = "http_client"
const val CONVERTER_FACTORY = "converter_factory"
const val RETROFIT_TIMEOUT = 60L

@Module
class ApiModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Reusable
        internal fun provideApiServiceProvider(@Named(RETROFIT_PROVIDER) retrofitProvider: RetrofitProvider): ApiServiceProvider =
            object : ApiServiceProvider {
                private val retrofit by lazy { retrofitProvider.getInstance() }
                private val apiService by lazy { retrofit.create(ApiService::class.java) }

                override fun getInstance() = apiService
            }

        @Provides
        @JvmStatic
        @Reusable
        @Named(HTTP_BUILDER)
        fun provideHttpBuilder(
            interceptorProvider: InterceptorsSetter
        ) = OkHttpClient.Builder().apply {
            interceptorProvider.addInterceptorsToOkHttpBuilder(this)
            readTimeout(RETROFIT_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(RETROFIT_TIMEOUT, TimeUnit.SECONDS)
        }

        @Provides
        @JvmStatic
        @Reusable
        @Named(HTTP_CLIENT)
        internal fun provideHttpClient(
            httpBuilder: OkHttpClient.Builder
        ) = httpBuilder.build()

        @Provides
        @JvmStatic
        @Named(RETROFIT_PROVIDER)
        internal fun provideRetrofit(
            retrofitBuilder: Retrofit.Builder,
            @Named(BASE_URL_PROVIDER) baseUrlProvider: StringProvider,
            @Named(HTTP_CLIENT) httpClient: OkHttpClient
        ): RetrofitProvider = object : RetrofitProvider {
            private val baseUrl by lazy { baseUrlProvider.getInstance() }

            override fun getInstance(): Retrofit {
                return retrofitBuilder
                    .client(httpClient)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }

        @Provides
        @JvmStatic
        @Named(BASE_URL_PROVIDER)
        internal fun provideBaseUrlProvider(): StringProvider =
            object : StringProvider {
                private val baseUrl by lazy {
                    "http://app.check24.de/"
                }

                override fun getInstance() = baseUrl
            }
    }
}
