package com.asimgasimzade.check24challenge.framework.di

import com.asimgasimzade.check24challenge.presentation.HomeActivity
import com.asimgasimzade.check24challenge.presentation.HomeViewModel
import com.asimgasimzade.check24challenge.presentation.productdetails.ProductDetailsFragment
import com.asimgasimzade.check24challenge.presentation.productdetails.ProductDetailsViewModel
import com.asimgasimzade.check24challenge.presentation.productlist.ProductListFragment
import com.asimgasimzade.check24challenge.presentation.productlist.ProductListViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HomeActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    internal abstract fun bindProductListFragment(): ProductListFragment

    @ContributesAndroidInjector
    internal abstract fun bindProductDetailsFragment(): ProductDetailsFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideHomeViewModelFactory(viewModel: HomeViewModel): ViewModelProviderFactory<HomeViewModel> {
            return ViewModelProviderFactory(viewModel)
        }

        @Provides
        @JvmStatic
        internal fun provideProductListViewModelFactory(viewModel: ProductListViewModel): ViewModelProviderFactory<ProductListViewModel> {
            return ViewModelProviderFactory(viewModel)
        }

        @Provides
        @JvmStatic
        internal fun provideProductDetailsViewModelFactory(viewModel: ProductDetailsViewModel): ViewModelProviderFactory<ProductDetailsViewModel> {
            return ViewModelProviderFactory(viewModel)
        }
    }
}
