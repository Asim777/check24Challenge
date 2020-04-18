package com.asimgasimzade.check24challenge.framework.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.asimgasimzade.check24challenge.data.ProductsDataSource
import com.asimgasimzade.check24challenge.data.ProductsRepository
import com.asimgasimzade.check24challenge.data.ProductsRepositoryType
import com.asimgasimzade.check24challenge.framework.ApiServiceProvider
import com.asimgasimzade.check24challenge.framework.AppSchedulerProvider
import com.asimgasimzade.check24challenge.framework.SchedulerProvider
import com.asimgasimzade.check24challenge.framework.remote.RemoteProductsDataSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton
import javax.sql.DataSource

@Module
class AppModule {

    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideResources(app: Application): Resources = app.resources

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    @Reusable
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(
            "check24challenge.preferences", Context.MODE_PRIVATE
        )

    @Provides
    @Singleton
    fun provideProductsRepository(
        dataSource: ProductsDataSource
    ): ProductsRepositoryType = ProductsRepository(dataSource)

    @Provides
    @Reusable
    fun provideRemoteProductsDataSource(
        apiServiceProvider: ApiServiceProvider
    ): ProductsDataSource = RemoteProductsDataSource(apiServiceProvider)
}
