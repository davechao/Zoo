package com.bank.zoo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.bank.zoo.R
import com.bank.zoo.ui.base.BaseActivity
import com.bank.zoo.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateTo(HomeFragment())
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}