package com.example.user.cowsandbulls.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.user.cowsandbulls.model.entities.Game

@Dao
public interface GameDao {

    @Insert
    fun newGame(game: Game)

    @Query("SELECT * FROM games ORDER BY startDate DESC")
    fun getAllGames(): List<Game>

    @Query("SELECT * FROM games WHERE id = :id")
    fun loadGame(id: Int): Game
}