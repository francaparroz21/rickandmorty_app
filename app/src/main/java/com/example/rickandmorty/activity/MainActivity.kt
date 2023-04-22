package com.example.rickandmorty.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.adapter.CharacterAdapter
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.mvvm.contract.MainContract
import com.example.rickandmorty.mvvm.model.MainModel
import com.example.rickandmorty.mvvm.viewmodel.MainViewModel
import com.example.rickandmorty.mvvm.viewmodel.factory.ViewModelFactory
import com.example.rickandmorty.service.CharacterClient
import com.example.rickandmorty.service.CharacterRequestGenerator
import com.example.rickandmorty.service.CharacterService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                arrayOf(
                    MainModel(
                        CharacterService(
                            CharacterRequestGenerator.createService(CharacterClient::class.java),
                        ),
                    ),
                ),
            ),
        )[MainViewModel::class.java]
        viewModel.getValue().observe(this) {}
    }

    private fun updateUI(data: MainViewModel.MainData) {
        when (data.status) {
            MainViewModel.MainStatus.SHOW -> {
                binding.recycler.layoutManager = LinearLayoutManager(this)
                binding.recycler.adapter = CharacterAdapter(data.characters)
            }
        }
    }
}