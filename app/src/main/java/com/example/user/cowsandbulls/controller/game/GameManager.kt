package com.example.user.cowsandbulls.controller.game

import android.content.SharedPreferences
import android.util.Log
import com.example.user.cowsandbulls.model.AppDatabase
import com.example.user.cowsandbulls.model.entities.Game
import com.example.user.cowsandbulls.model.entities.Step
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameManager @Inject constructor(private val database: AppDatabase, private var sPref: SharedPreferences){

    fun startNewGame(playerId: Int): Game {
        val date = Date()
        val game = Game(getGoalForGame(), playerId, date.time)
        database.gameDao().newGame(game)
        return game
    }

    fun test(listener : ()->Unit){
        listener()

        var a : String? = null

        var b = a?.length ?: 4


    }

    fun getGoalForGame() : String {
        var temp: Int
        val result = StringBuilder()
        while (result.length < 4) {
            temp = (0 .. 9).random()
            result.append(when{
                result.isEmpty() && temp == 0 -> ""
                !result.contains(temp.toString()) -> temp.toString()
                else -> ""
            })
        }
        return result.toString()
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) +  start

    fun saveAnswer(text: String): Step? {

        if(isCorrectValue(text))
        return null
    }

    private fun isCorrectValue(text: String): Boolean {
        val value = text.toCharArray()
        for (i in text) {
        //   if  (text.substring(i.))
        }
        return true
    }
}