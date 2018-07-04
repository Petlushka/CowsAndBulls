package com.example.user.cowsandbulls.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.user.cowsandbulls.model.dao.GameDao
import com.example.user.cowsandbulls.model.dao.PlayerDao
import com.example.user.cowsandbulls.model.dao.StepDao
import com.example.user.cowsandbulls.model.entities.Game
import com.example.user.cowsandbulls.model.entities.Player
import com.example.user.cowsandbulls.model.entities.Step

@Database(entities = arrayOf(Player::class, Game::class, Step::class), version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun gameDao(): GameDao
    abstract fun playerDao(): PlayerDao
    abstract fun stepDao(): StepDao


}