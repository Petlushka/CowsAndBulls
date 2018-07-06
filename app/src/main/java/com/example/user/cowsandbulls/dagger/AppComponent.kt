package com.example.user.cowsandbulls.dagger

import com.example.user.cowsandbulls.controller.game.GameActivity
import com.example.user.cowsandbulls.controller.players.PlayersActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {


    fun inject(target: PlayersActivity)

    fun inject(target: GameActivity)
}