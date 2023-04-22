package com.example.rickandmorty.mvvm.viewmodel.factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.mvvm.contract.MainContract
import com.example.rickandmorty.mvvm.viewmodel.MainViewModel

class ViewModelFactory(private val params: Array<Any>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> MainViewModel(params[0] as MainContract.Model) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}