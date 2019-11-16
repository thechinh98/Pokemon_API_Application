package com.example.pokemonapiapplication.Items.PokemonInfomation

import com.example.pokemonapiapplication.Items.Moves
import com.google.gson.annotations.SerializedName

class PokemonMoves {
    @SerializedName("move")
    var move : Moves

    constructor(move : Moves){
        this.move = move
    }

}