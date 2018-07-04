package com.example.user.cowsandbulls.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.user.cowsandbulls.model.entities.Player

@Dao
public interface PlayerDao {

    @Insert
    fun insertPlayer(player: Player)

    @Query("SELECT * FROM players")
    fun loadAlPlayers(): List<Player>

    @Delete
    fun deletePlayer(player: Player)
}