package com.bank.zoo.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bank.zoo.R
import com.bank.zoo.ui.main.MainViewModel

abstract class BaseFragment : Fragment() {

    open var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            mainViewModel = ViewModelProvider(it).get(MainViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    fun navigateTo(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        if (!this.isHidden) {
            transaction.hide(this)
            transaction.addToBackStack(this.tag)
        }
        transaction.add(R.id.layout_fragment, fragment, fragment.tag).commit()
    }

}