package com.example.user.cowsandbulls.controller.players

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.user.cowsandbulls.R
import com.example.user.cowsandbulls.model.entities.Player

class PlayersAdapter(var players:MutableList<Player>,
                     val onDeletePlayerListener: OnDeletePlayerListener,
                     val onSelectPlayerListener: onSelectPlayerListener): RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {


    fun setData (players: MutableList<Player>) {
        this.players = players
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.playerName.text = players[position].userName
        holder.playerName.setOnClickListener { onSelectPlayerListener(players[position]) }
        holder.deleteBtn.setOnClickListener{
            onDeletePlayerListener(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false)
        return PlayerViewHolder(v)
    }


    override fun getItemCount(): Int = players.size


    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val playerName: TextView = itemView.findViewById(R.id.player_name)
        val deleteBtn: ImageView = itemView.findViewById(R.id.delete_player)





    }
}