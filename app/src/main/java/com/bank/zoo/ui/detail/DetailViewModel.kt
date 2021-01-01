package com.bank.zoo.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import com.bank.zoo.model.repository.ZooRepository
import com.bank.zoo.ui.base.BaseViewModel

class DetailViewModel @ViewModelInject constructor(
    private var zooRepository: ZooRepository
) : BaseViewModel() {

}