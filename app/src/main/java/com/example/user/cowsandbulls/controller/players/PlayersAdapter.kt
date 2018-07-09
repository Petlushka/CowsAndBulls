package com.example.user.cowsandbulls.controller.players

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.cowsandbulls.R
import com.example.user.cowsandbulls.R.id.playerName
import com.example.user.cowsandbulls.model.entities.Player
import kotlinx.android.synthetic.main.player_item.view.*

class PlayersAdapter(var players:MutableList<Player>,
                     val onDeletePlayerListener: OnDeletePlayerListener,
                     val onSelectPlayerListener: onSelectPlayerListener): RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {


    fun setData (players: MutableList<Player>) {
        this.players = players
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bindPlayer(players[position])
        holder.itemView.playerName.setOnClickListener { onSelectPlayerListener(players[position].id) }
        holder.itemView.deletePlayer.setOnClickListener{
            onDeletePlayerListener(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false)
        return PlayerViewHolder(v)
    }


    override fun getItemCount(): Int = players.size


    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindPlayer(player: Player) {
            itemView.playerName.text = player.userName
           // itemView.deletePlayer.setOnClickListener(onDeletePlayer)
        }



    }
}