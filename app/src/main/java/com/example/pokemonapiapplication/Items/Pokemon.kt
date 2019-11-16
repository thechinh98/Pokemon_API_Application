package com.example.pokemonapiapplication.Items

import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonMoves
import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonSprites
import com.example.pokemonapiapplication.Items.PokemonInfomation.PokemonStats
import com.google.gson.annotations.SerializedName

class Pokemon {
    @SerializedName("name")
    var name: String

    @SerializedName("stats")
    var stats: ArrayList<PokemonStats>

    //stats[0] : SPD
    //stats[1] : SDEF
    //stats[2] : SATK
    //stats[3] : DEF
    //stats[4] : ATK
    //stats[5] : HP

    @SerializedName("sprites")
    var sprites : PokemonSprites

    @SerializedName("moves")
    var moves : ArrayList<PokemonMoves>

    constructor(name: String, stats: ArrayList<PokemonStats>, sprites: PokemonSprites, moves: ArrayList<PokemonMoves>) {
        this.name = name
        this.stats = stats
        this.sprites = sprites
        this.moves = moves
    }
}