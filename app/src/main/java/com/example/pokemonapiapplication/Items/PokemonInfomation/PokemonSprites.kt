package com.example.pokemonapiapplication.Items.PokemonInfomation

import com.google.gson.annotations.SerializedName

class PokemonSprites {
    @SerializedName("front_default")
    var imgUrl : String

    constructor(imgUrl : String){
        this.imgUrl = imgUrl
    }
}