package com.asimgasimzade.check24challenge.presentation

import android.app.Application
import com.asimgasimzade.check24challenge.framework.SchedulerProvider
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModel
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModelInputs
import com.asimgasimzade.check24challenge.presentation.base.BaseViewModelOutputs
import javax.inject.Inject

interface HomeViewModelInputs : BaseViewModelInputs

interface HomeViewModelOutputs : BaseViewModelOutputs

open class HomeViewModel @Inject constructor(
    application: Application,
    schedulerProvider: SchedulerProvider
) : BaseViewModel(application, schedulerProvider), HomeViewModelInputs, HomeViewModelOutputs {

    override val inputs: HomeViewModelInputs
        get() = this

    override val outputs: HomeViewModelOutputs
        get() = this
}