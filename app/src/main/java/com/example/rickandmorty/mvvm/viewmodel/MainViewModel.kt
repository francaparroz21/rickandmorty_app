package com.example.rickandmorty.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.mvvm.contract.MainContract
import com.example.rickandmorty.service.model.Character
import com.example.rickandmorty.util.CoroutineResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val model: MainContract.Model) : ViewModel(), MainContract.ViewModel {
    private val mutableLiveData: MutableLiveData<MainData> = MutableLiveData()
    override fun getValue(): LiveData<MainData> = mutableLiveData

    data class MainData(
        val status: MainStatus,
        val characters: List<Character>
    )

    enum class MainStatus {
        SHOW
    }


    override fun callServiceCharacters() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) { model.getCharacters() }.let { res ->
                when (res) {
                    is CoroutineResult.Success -> mutableLiveData.value =
                        MainData(MainStatus.SHOW, res.data.characters)

                    is CoroutineResult.Failure -> {}
                }
            }
        }

}