package com.example.pokemonapiapplication.Items.PokemonInfomation

import com.google.gson.annotations.SerializedName

class PokemonStats {
    @SerializedName("base_stat")
    var baseStats : Int
    @SerializedName("effort")
    var effort : Int
    constructor(baseStats : Int, effort : Int){
        this.baseStats = baseStats
        this.effort = effort
    }
}