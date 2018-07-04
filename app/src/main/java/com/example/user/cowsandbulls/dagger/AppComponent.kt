package com.example.user.cowsandbulls.dagger

import com.example.user.cowsandbulls.views.MainActivity
import com.example.user.cowsandbulls.views.PlayerPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PlayerPresenter::class])
interface AppComponent {

    fun inject(target: MainActivity)
}