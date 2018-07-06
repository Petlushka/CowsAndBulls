package com.example.user.cowsandbulls.controller.players

import com.example.user.cowsandbulls.model.entities.Player

interface OnDeletePlayerListener {

   operator fun invoke(position: Int)
}

interface onSelectPlayerListener {

   operator fun invoke(player: Player)
}
