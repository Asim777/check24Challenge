package com.asimgasimzade.check24challenge.presentation.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.asimgasimzade.check24challenge.framework.SchedulerProvider
import com.asimgasimzade.check24challenge.framework.di.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<T : ViewModel, B : ViewDataBinding> : DaggerAppCompatActivity(),
    BaseView<T> {

    @Inject
    protected lateinit var vmFactory: ViewModelProviderFactory<T>

    @Inject
    protected lateinit var schedulers: SchedulerProvider

    protected lateinit var binding: B
    protected val subscriptions = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, bindingLayout)
    }

    override fun onDestroy() {
        subscriptions.clear()
        super.onDestroy()
    }
}
