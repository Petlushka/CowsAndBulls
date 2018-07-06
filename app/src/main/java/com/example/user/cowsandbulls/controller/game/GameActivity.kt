package com.example.user.cowsandbulls.controller.game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.example.user.cowsandbulls.MyApp
import com.example.user.cowsandbulls.R
import com.example.user.cowsandbulls.controller.players.PLAYER_ID_KEY
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class GameActivity : AppCompatActivity() {

    @Inject lateinit var manager: GameManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        (application as MyApp).appComponent.inject(this)
        val playerId = intent.getIntExtra(PLAYER_ID_KEY, 0)
        start_game_btn.setOnClickListener {
            doAsync {
                manager.startNewGame(playerId)
            }
        }
        ok_btn.setOnClickListener{
            val answerValue = answer_value.text.toString()
            doAsync {
                val savedAnswer = manager.saveAnswer(answerValue)
                uiThread {
                if (savedAnswer == null)
                    showErrorDialog()
                }

            }

        }

    }

    private fun showErrorDialog() {
       AlertDialog.Builder(this)
                .setTitle(R.string.incorrect_answer)
                .setMessage(R.string.incorrect_answer_msg)
                .setPositiveButton(R.string.ok, {dialog, i -> dialog.dismiss()} ).show()

    }
}
