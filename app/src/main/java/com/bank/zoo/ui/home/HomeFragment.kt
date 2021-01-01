package com.bank.zoo.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bank.zoo.R
import com.bank.zoo.model.api.ApiResult.*
import com.bank.zoo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar.view.*
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbarUi()
        setupContentUi()

        viewModel.zooResult.observe(viewLifecycleOwner, {
            when (it) {
                is Success -> it.result?.let { data -> generalVideoAdapter.updateData(data) }
                is Error -> Timber.e("Error: $it")
                else -> {
                }
            }
        })

        viewModel.getZoo()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    private fun setupToolbarUi() {
        layout_toolbar.tv_toolbar_title.text = getString(R.string.home_title)
    }

    private fun setupContentUi() {
        rv_home.also {
            it.setHasFixedSize(true)
            it.adapter = generalVideoAdapter
        }
    }

    private val generalVideoAdapter by lazy {
        HomeAdapter(homeFuncListener)
    }

    private val homeFuncListener by lazy {
        HomeFuncListener(
            onItemClick = {
                Timber.d("Home Item Click")
            }
        )
    }

}