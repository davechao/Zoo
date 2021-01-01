package com.bank.zoo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.bank.zoo.R
import com.bank.zoo.ui.base.BaseActivity
import com.bank.zoo.ui.home.HomeFragment
import com.bank.zoo.widget.utility.GeneralUtils
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateTo(HomeFragment())
    }

    override fun onBackPressed() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        takeIf { backStackEntryCount == 0 }?.run {
            takeIf { viewModel.needCloseApp }?.run { finish() }
                ?: run {
                    viewModel.startBackExitAppTimer()
                    GeneralUtils.showToast(this, getString(R.string.press_again_exit))
                }
        } ?: run { supportFragmentManager.popBackStack() }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}