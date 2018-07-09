package com.example.user.cowsandbulls.controller.game

import android.content.SharedPreferences
import android.util.Log
import com.example.user.cowsandbulls.model.AppDatabase
import com.example.user.cowsandbulls.model.entities.Game
import com.example.user.cowsandbulls.model.entities.Step
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
const val CURRENT_GAME_KEY = "CURRENT_GAME_KEY"

@Singleton
class GameManager @Inject constructor(private val database: AppDatabase, private var sPref: SharedPreferences){



    fun startNewGame(playerId: Int): Game {
        Log.d("MyLogs", "playerId $playerId")
        val date = Date()
        val game = Game(goal = getGoalForGame(), userId = playerId, startDate = date.time)
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

    fun saveAnswer(value: String, game: Game): Step? {
        return if(isCorrectValue(value)) {
            var cowsCount = 0
            var bullsCount = 0
            for (i in value.indices) {
                when {
                    value[i] == game.goal[i] -> bullsCount++
                    game.goal.contains(value[i]) -> cowsCount++
                    else -> Log.d("MyLogs", "There is no ${value[i]} in ${game.goal}")
                }
            }
            Log.d("MyLogs", "game id - ${game.id}")
            val step = Step(value = value, cowsCount = cowsCount, bullsCount = bullsCount, gameId = game.id, time = Date().time)
            database.stepDao().addStep(step)
            step
        } else null
    }


    private fun isCorrectValue(text: String): Boolean {
        if (text.startsWith('0')) return false
        for (i in text.indices) {
           if(text.count{it == text[i]} > 1) return false
        }
        return true
    }
}