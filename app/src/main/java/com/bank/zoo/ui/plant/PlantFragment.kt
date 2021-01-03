package com.bank.zoo.ui.plant

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bank.zoo.R
import com.bank.zoo.model.api.vo.PlantItem
import com.bank.zoo.ui.base.BaseFragment
import com.bumptech.glide.Glide
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
            setupContentUi(it)
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

    private fun setupContentUi(item: PlantItem) {
        Glide.with(requireContext())
            .load(item.pic01Url)
            .placeholder(R.drawable.ic_picture_small_empty)
            .error(R.drawable.ic_picture_small_empty)
            .into(iv_plant)

        tv_cn_name.text = item.nameCh
        tv_en_name.text = item.nameEn
        tv_also_known.text = item.alsoKnown
        tv_brief.text = item.brief
        tv_feature.text = item.feature
        tv_function.text = item.functionApplication
        tv_update_time.text = item.update
    }
}