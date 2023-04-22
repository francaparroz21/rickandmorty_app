package com.example.rickandmorty.service.model

import com.google.gson.annotations.SerializedName

data class CharacterList(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: String,
    @SerializedName("results")
    var characters: List<Character>
)