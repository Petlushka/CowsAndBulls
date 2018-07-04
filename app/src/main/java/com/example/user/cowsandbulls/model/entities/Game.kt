package com.example.user.cowsandbulls.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "games",
        foreignKeys = [(ForeignKey(entity = Player::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("userId"),
                onDelete = ForeignKey.CASCADE))],
        indices = [Index("userId")])
public class Game (@PrimaryKey(autoGenerate = true)val id: Int,
                   val goal: String,
                   val userId: Int,
                   val startDate: Long)