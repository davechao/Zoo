package com.bank.zoo.ui.plant

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bank.zoo.R
import com.bank.zoo.model.api.vo.PlantItem
import com.bank.zoo.model.api.vo.ZooItem
import com.bank.zoo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_plant.*
import kotlinx.android.synthetic.main.toolbar.view.*

@AndroidEntryPoint
class PlantFragment : BaseFragment() {

    companion object {
        private const val KEY_ITEM = "KEY_ITEM"
        fun createFragment(item: PlantItem): Fragment {
            val bundle = Bundle().also { it.putParcelable(KEY_ITEM, item) }
            return PlantFragment().also { it.arguments = bundle }
        }
    }

    private val viewModel: PlantViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = arguments?.getParcelable<PlantItem>(KEY_ITEM)

        item?.let {
            setupToolbarUi(it)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_plant
    }

    private fun setupToolbarUi(item: PlantItem) {
        layout_toolbar.tv_toolbar_title.text = item.nameCh

        layout_toolbar.toolbar.also {
            it.navigationIcon = ContextCompat.getDrawable(
                requireContext(), R.drawable.ic_baseline_arrow_back_24
            )
            it.setNavigationOnClickListener { onBackPressed() }
        }
    }
}