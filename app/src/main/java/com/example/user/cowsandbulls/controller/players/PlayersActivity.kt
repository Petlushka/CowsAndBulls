package com.example.user.cowsandbulls.controller.players

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.user.cowsandbulls.MyApp
import com.example.user.cowsandbulls.R
import com.example.user.cowsandbulls.controller.game.GameActivity
import com.example.user.cowsandbulls.model.entities.Player
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import javax.inject.Inject

const val PLAYER_ID_KEY = "PLAYER_ID_KEY"

class PlayersActivity : AppCompatActivity() {


    @Inject
    lateinit var manager: PlayerManager

    private var players: MutableList<Player> = mutableListOf()
    private lateinit var adapter: PlayersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_players)

        (application as MyApp).appComponent.inject(this)

        adapter = PlayersAdapter(players, object : OnDeletePlayerListener {
            override fun invoke(position: Int) {
                doAsync {
                    manager.deletePlayer(players[position])
                    uiThread {
                        // players.remove(player)
                        players.removeAt(position)
                        adapter.notifyItemRemoved(position)
                    }
                }
            }
        },
                object : onSelectPlayerListener {
                    override fun invoke(player: Player) {
                        manager.saveCurrentUsed(player.id)
                        startNewGame(player.id)
                    }
                })
        val recyclerView = find<RecyclerView>(R.id.players_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addBtn = find<Button>(R.id.btn_add)
        addBtn.setOnClickListener { addPlayer() }

        getData()
    }

    private fun startNewGame(playerId: Int) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra(PLAYER_ID_KEY, playerId)
        startActivity(intent)
    }

    private fun getData() {
        doAsync {
            players = manager.getAllPlayers()
            uiThread { adapter.setData(players) }
        }
    }

    private fun addPlayer() {
        doAsync {
            val player = manager.addNewPlayer()
            uiThread {
                players.add(player)
                adapter.notifyItemInserted(players.size - 1)
            }
        }
    }
}
