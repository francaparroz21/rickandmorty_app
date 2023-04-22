package com.example.rickandmorty.service
import com.example.rickandmorty.service.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET

interface CharacterClient {
    @GET("/api/character")
    fun getCharacters() : Call<CharacterList>
}