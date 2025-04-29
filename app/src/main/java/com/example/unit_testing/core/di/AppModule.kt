package com.example.unit_testing.core.di

import com.example.unit_testing.data.repo.TaskRepo
import com.example.unit_testing.data.repo.TaskRepoImpl
import com.example.unit_testing.data.repo.UserRepo
import com.example.unit_testing.data.repo.UserRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTasksRepo(): TaskRepo {
        return TaskRepoImpl()
    }

    @Provides
    @Singleton
    fun provideUserRepo(): UserRepo {
        return UserRepoImpl()
    }
}