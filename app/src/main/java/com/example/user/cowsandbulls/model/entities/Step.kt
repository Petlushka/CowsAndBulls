package com.example.user.cowsandbulls.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "steps",
        foreignKeys = [(ForeignKey(entity = Game::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("gameId"),
                onDelete = ForeignKey.CASCADE))],
        indices = [Index("gameId")])
data class Step(@PrimaryKey(autoGenerate = true)
                var id: Int = 0,
                val value: String,
                val cowsCount: Int,
                val bullsCount: Int,
                val gameId: Int,
                val time: Long)