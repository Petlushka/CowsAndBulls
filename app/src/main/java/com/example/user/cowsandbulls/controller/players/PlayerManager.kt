package com.example.user.cowsandbulls.controller.players

import android.content.SharedPreferences
import com.example.user.cowsandbulls.model.AppDatabase
import com.example.user.cowsandbulls.model.entities.Player
import javax.inject.Inject
import javax.inject.Singleton

const val CURRENT_PLAYER_KEY: String = "CURRENT_PLAYER_KEY"
var playerCount = 1

@Singleton
class PlayerManager @Inject constructor(private val database: AppDatabase, private var sPref: SharedPreferences) {


    fun getAllPlayers(): MutableList<Player> = database.playerDao().loadAlPlayers()


    fun saveCurrentUsed(userId: Int) {
        sPref.edit().putInt(CURRENT_PLAYER_KEY, userId).apply()
    }

    fun getCurrentPlayer() : Player {
        val playerId = sPref.getInt(CURRENT_PLAYER_KEY, 0)
        return database.playerDao().getPLayer(playerId)
    }

    fun deletePlayer(player: Player) {
        database.playerDao().deletePlayer(player)
    }


    fun addNewPlayer(): Player {
        val player = Player("Player Player ${playerCount++}")
        database.playerDao().insertPlayer(player)
        return player
    }




}