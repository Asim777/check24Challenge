package com.asimgasimzade.check24challenge.framework.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorsSetter(
    private val isDebug: Boolean,
    private val hostSelectionInterceptor: Interceptor?,
    private val httpLoggingInterceptor: HttpLoggingInterceptor
) {
    fun addInterceptorsToOkHttpBuilder(okHttpBuilder: OkHttpClient.Builder) {
        val listInterceptors = mutableListOf<Interceptor>()
        if (isDebug) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            listInterceptors.add(httpLoggingInterceptor)
        }
        hostSelectionInterceptor?.let {
            listInterceptors.add(it)
        }
        listInterceptors.forEach { interceptor -> okHttpBuilder.addInterceptor(interceptor) }
    }
}
