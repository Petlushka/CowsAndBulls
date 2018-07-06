package com.example.user.cowsandbulls.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "players")
data class Player (var userName: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}