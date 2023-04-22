package com.example.rickandmorty.service

import com.example.rickandmorty.service.model.CharacterList
import com.example.rickandmorty.util.CoroutineResult

class CharacterService(private val client: CharacterClient) {
    fun getCharacters(): CoroutineResult<CharacterList> {
        try {
            val res = client.getCharacters().execute()
            if (res.isSuccessful) {
                res.body()?.let { return CoroutineResult.Success(it) }
            }
            return CoroutineResult.Failure(Exception(res.errorBody().toString()))
        } catch (e: Exception) {
            return CoroutineResult.Failure(e)
        }
    }
}