package com.example.user.cowsandbulls.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "players")
public class Player (
        @PrimaryKey(autoGenerate = true) val id: Int,
        var username: String)