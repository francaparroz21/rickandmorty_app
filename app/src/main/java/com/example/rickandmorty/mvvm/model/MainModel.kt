package com.example.rickandmorty.mvvm.model

import com.example.rickandmorty.mvvm.contract.MainContract
import com.example.rickandmorty.service.CharacterService
import com.example.rickandmorty.service.model.CharacterList
import com.example.rickandmorty.util.CoroutineResult

class MainModel(private val service: CharacterService): MainContract.Model {
    override fun getCharacters(): CoroutineResult<CharacterList> {
        val characters = service.getCharacters()
        return characters
    }

}