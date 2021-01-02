package com.bank.zoo.ui.plant

import androidx.hilt.lifecycle.ViewModelInject
import com.bank.zoo.model.repository.ZooRepository
import com.bank.zoo.ui.base.BaseViewModel

class PlantViewModel @ViewModelInject constructor(
    private var zooRepository: ZooRepository
) : BaseViewModel()