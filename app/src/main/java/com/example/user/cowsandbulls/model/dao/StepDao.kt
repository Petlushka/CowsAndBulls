package com.example.user.cowsandbulls.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.user.cowsandbulls.model.entities.Step

@Dao
interface StepDao {

    @Insert
    fun addStep(step: Step)

    @Query("SELECT * FROM steps WHERE gameId = :gameId")
    fun getAllStepsForGame(gameId: Int): List<Step>
}