package com.glen.daggerbasic.di

import dagger.Module

@Module(subcomponents = [PredictComponent::class, LogHistoryComponent::class])
class AppSubComponents