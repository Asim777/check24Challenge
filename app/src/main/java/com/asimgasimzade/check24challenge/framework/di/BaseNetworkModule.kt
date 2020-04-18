package com.asimgasimzade.check24challenge.framework.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.Nullable
import com.asimgasimzade.check24challenge.BuildConfig
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
open class BaseNetworkModule {

    @Provides
    fun provideRetrofitBuilder(
        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
    }

    @Provides
    fun provideHttpBuilder(
        hostSelectionInterceptor: Interceptor?
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(httpLoggingInterceptor)
            }

            if (hostSelectionInterceptor != null) {
                addInterceptor(hostSelectionInterceptor)
            }

            readTimeout(RETROFIT_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(RETROFIT_TIMEOUT, TimeUnit.SECONDS)
        }
    }

    @Provides
    @Singleton
    @Nullable
    fun provideHostSelectionInterceptor(): Interceptor? = getHostSelectionInterceptor()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Reusable
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Reusable
    fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Reusable
    fun provideConnectivityManager(context: Context): ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    protected open fun getHostSelectionInterceptor(): Interceptor? = null

    companion object {
        const val RETROFIT_TIMEOUT = 60L
    }
}
