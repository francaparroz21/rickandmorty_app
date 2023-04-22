package com.example.rickandmorty.service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterRequestGenerator {
    private const val API_CHARACTERS_URL = "https://rickandmortyapi.com/"

    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
        .baseUrl(API_CHARACTERS_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService (serviceClass: Class<S>):S{
        val retrofit = builder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }
}