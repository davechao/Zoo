package com.bank.zoo.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bank.zoo.model.api.ApiResult
import com.bank.zoo.model.api.vo.PlantItem
import com.bank.zoo.model.repository.ZooRepository
import com.bank.zoo.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private var zooRepository: ZooRepository
) : BaseViewModel() {

    private val _plantResult = MutableLiveData<ApiResult<ArrayList<PlantItem>?>>()
    val plantResult: LiveData<ApiResult<ArrayList<PlantItem>?>> = _plantResult

    fun getPlant() {
        viewModelScope.launch {
            zooRepository.getPlant()
                .catch { e -> _plantResult.value = ApiResult.error(e) }
                .collect { _plantResult.value = ApiResult.success(it) }
        }
    }
}