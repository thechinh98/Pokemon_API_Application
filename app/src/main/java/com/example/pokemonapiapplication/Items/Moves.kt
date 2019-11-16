package com.example.pokemonapiapplication.Items

import com.google.gson.annotations.SerializedName

class Moves {
    @SerializedName("name")
    var movesNames: String

    constructor(movesNames : String){
        this.movesNames = movesNames
    }
}
