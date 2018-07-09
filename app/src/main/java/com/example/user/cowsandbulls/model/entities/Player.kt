package com.example.user.cowsandbulls.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "players")
data class Player ( @PrimaryKey(autoGenerate = true)
                    var id: Int = 0, var userName: String) {
}