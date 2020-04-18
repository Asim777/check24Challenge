package com.asimgasimzade.check24challenge.presentation.base

import androidx.lifecycle.ViewModel

interface BaseView<T : ViewModel> {
    val viewModel: T
    val bindingLayout: Int
}
