package com.example.user.cowsandbulls.controller.game

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import com.example.user.cowsandbulls.MyApp
import com.example.user.cowsandbulls.R
import com.example.user.cowsandbulls.controller.players.CURRENT_PLAYER_KEY
import com.example.user.cowsandbulls.model.entities.Game
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class GameActivity : AppCompatActivity() {

    @Inject lateinit var manager: GameManager
    private var game: Game? = null

    @Inject lateinit var sPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        (application as MyApp).appComponent.inject(this)
        val playerId = sPref.getInt(CURRENT_PLAYER_KEY, 0)
        Log.d("MyLogs", "playerId - $playerId")
        val adapter = StepAdapter()
        startGameBtn.setOnClickListener {
            doAsync {
                game = manager.startNewGame( playerId)
                uiThread {
                    startGameBtn.visibility = View.GONE
                    answerValueContainer.visibility = View.VISIBLE
                }
            }
        }
        okBtn.setOnClickListener {
            val answerValue = answerValue.text.toString()
            doAsync {
                val savedAnswer = manager.saveAnswer(answerValue, game!!)
                uiThread {
                    if (savedAnswer == null) {
                        showErrorDialog()
                    } else {
                        adapter.addStep(savedAnswer)
                    }
                }
            }
        }
    }

    private fun showErrorDialog() {
        AlertDialog.Builder(this)
                .setTitle(R.string.incorrect_answer)
                .setMessage(R.string.incorrect_answer_msg)
                .setPositiveButton(R.string.ok, { dialog, i -> dialog.dismiss() }).show()
    }

}
