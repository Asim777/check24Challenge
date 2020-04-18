package com.asimgasimzade.check24challenge.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.asimgasimzade.check24challenge.R
import com.asimgasimzade.check24challenge.databinding.ActivityHomeBinding
import com.asimgasimzade.check24challenge.presentation.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {
    private val navController by lazy { findNavController(R.id.homeNavigationFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override val bindingLayout =
        R.layout.activity_home
    override val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, vmFactory).get(HomeViewModel::class.java)
    }
}
