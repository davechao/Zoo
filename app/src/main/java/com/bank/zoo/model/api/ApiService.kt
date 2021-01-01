package com.bank.zoo.model.api

import com.bank.zoo.model.api.vo.ApiBaseItem
import com.bank.zoo.model.api.vo.PagingItem
import com.bank.zoo.model.api.vo.PlantItem
import com.bank.zoo.model.api.vo.ZooItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun getZoo(): Response<ApiBaseItem<PagingItem<ArrayList<ZooItem>>>>

    @GET("f18de02f-b6c9-47c0-8cda-50efad621c14?scope=resourceAquire")
    suspend fun getPlant(): Response<ApiBaseItem<PagingItem<ArrayList<PlantItem>>>>
}