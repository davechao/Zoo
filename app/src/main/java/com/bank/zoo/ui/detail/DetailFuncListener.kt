package com.bank.zoo.ui.detail

import com.bank.zoo.model.api.vo.PlantItem

class DetailFuncListener(
    val onOpenWeb: (String) -> Unit = { },
    val onPlantItemClick: (PlantItem) -> Unit = { },
)