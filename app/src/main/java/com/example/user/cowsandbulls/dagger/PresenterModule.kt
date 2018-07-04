package com.example.user.cowsandbulls.dagger

import com.example.user.cowsandbulls.views.PlayerPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providePlayersPreseter(): PlayerPresenter = PlayerPresenter()
}
