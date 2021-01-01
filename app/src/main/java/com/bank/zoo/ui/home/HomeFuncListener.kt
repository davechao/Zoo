package com.bank.zoo.ui.home

import com.bank.zoo.model.api.vo.ZooItem

class HomeFuncListener(
    val onItemClick: (item: ZooItem) -> Unit = { },
)