package com.example.imagesearchapp.di

import com.example.imagesearchapp.domain.repository.UnsplashRepository
import com.example.imagesearchapp.domain.repository.UnsplashRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
  @Binds
  fun provideMainRepositoryImpl(repository: UnsplashRepositoryImpl): UnsplashRepository

}