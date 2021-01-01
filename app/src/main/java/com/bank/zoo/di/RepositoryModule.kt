package com.bank.zoo.di

import com.bank.zoo.model.api.ApiService
import com.bank.zoo.model.repository.ZooRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun provideZooRepository(apiService: ApiService): ZooRepository {
        return ZooRepository(apiService)
    }
}