package com.example.rickandmorty.service.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("species")
    var species: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("status")
    var status: String
)