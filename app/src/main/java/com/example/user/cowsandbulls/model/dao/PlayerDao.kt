package com.example.user.cowsandbulls.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.user.cowsandbulls.model.entities.Player

@Dao
interface PlayerDao {

    @Insert
    fun insertPlayer(player: Player)

    @Query("SELECT * FROM players")
    fun loadAlPlayers(): MutableList<Player>

    @Delete
    fun deletePlayer(player: Player)

    @Query("SELECT * FROM players WHERE id = :playerId")
    fun getPLayer(playerId: Int): Player
}