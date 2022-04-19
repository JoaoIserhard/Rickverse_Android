package com.example.rickverse.service

import com.example.rickverse.model.CharactersResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface CharactersService {

    @GET("character")
    fun getAll(@Query("page") page: Int? = null): Call<CharactersResponse>

    @GET("characters/{id}")
    fun getCharacterInfo(@Path("id") id:Int): Call<CharactersResponse>
}