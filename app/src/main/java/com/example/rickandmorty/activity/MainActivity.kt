package com.example.rickandmorty.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.mvvm.contract.MainContract
import com.example.rickandmorty.mvvm.model.MainModel
import com.example.rickandmorty.mvvm.viewmodel.factory.ViewModelFactory

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelFactory(arrayOf(MainModel())))
    }
}