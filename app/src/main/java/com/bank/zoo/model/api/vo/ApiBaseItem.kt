package com.bank.zoo.model.api.vo

import com.google.gson.annotations.SerializedName

data class ApiBaseItem<T>(
    @SerializedName("result")
    val result: T?
)