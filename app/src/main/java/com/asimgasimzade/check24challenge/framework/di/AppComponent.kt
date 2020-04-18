package com.asimgasimzade.check24challenge.framework.di

import android.app.Application
import com.asimgasimzade.check24challenge.ApplicationClass
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        HomeActivityModule::class,
        ApiModule::class,
        BaseNetworkModule::class
    ]
)

interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: ApplicationClass)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
