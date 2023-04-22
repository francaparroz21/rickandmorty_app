package com.example.rickandmorty.mvvm.contract

import androidx.lifecycle.LiveData
import com.example.rickandmorty.mvvm.viewmodel.MainViewModel
import com.example.rickandmorty.service.model.CharacterList
import com.example.rickandmorty.util.CoroutineResult
import kotlinx.coroutines.Job

interface MainContract {
    interface Model {
        fun getCharacters(): CoroutineResult<CharacterList>
    }

    interface ViewModel {
        fun getValue(): LiveData<MainViewModel.MainData>
        fun callServiceCharacters(): Job
    }
}