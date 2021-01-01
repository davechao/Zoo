package com.bank.zoo.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bank.zoo.model.api.ApiResult
import com.bank.zoo.model.api.vo.ZooItem
import com.bank.zoo.model.repository.ZooRepository
import com.bank.zoo.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private var zooRepository: ZooRepository
) : BaseViewModel() {

    private val _zooResult = MutableLiveData<ApiResult<ArrayList<ZooItem>?>>()
    val zooResult: LiveData<ApiResult<ArrayList<ZooItem>?>> = _zooResult

    fun getZoo() {
        viewModelScope.launch {
            zooRepository.getZoo()
                .catch { e -> _zooResult.value = ApiResult.error(e) }
                .collect { _zooResult.value = ApiResult.success(it) }
        }
    }
}