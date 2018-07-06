package com.example.user.cowsandbulls.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.user.cowsandbulls.MyApp
import com.example.user.cowsandbulls.controller.game.GameManager
import com.example.user.cowsandbulls.model.AppDatabase
import com.example.user.cowsandbulls.controller.players.PlayerManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val app: Application){

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    fun providePlayerPresenter(appDatabase: AppDatabase, sharedPref: SharedPreferences): PlayerManager
            = PlayerManager(appDatabase, sharedPref)

    @Provides
    fun provideGameManager(appDatabase: AppDatabase, sharedPref: SharedPreferences): GameManager
            = GameManager(appDatabase, sharedPref)

    @Provides
    @Singleton
    fun provideAppDatabase() : AppDatabase = (app as MyApp).appDatabase

    @Provides
    @Singleton
    fun provideSharedPreference() : SharedPreferences = app.getSharedPreferences("MyPref", 0)

}