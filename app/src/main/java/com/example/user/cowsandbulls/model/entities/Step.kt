package com.example.user.cowsandbulls.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "steps",
        foreignKeys = [ForeignKey(entity = Game::class, parentColumns = arrayOf("id"), childColumns = arrayOf("gameId"))],
        indices = [Index("gameId")])
public class Step(@PrimaryKey(autoGenerate = true) val id: Long,
                  val value: String,
                  val cowsCount: Int,
                  val bullsCount: Int,
                  val gameId: Int,
                  val time: Long
                  )