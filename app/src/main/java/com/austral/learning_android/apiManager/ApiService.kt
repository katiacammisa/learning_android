package com.austral.learning_android.apiManager

import com.austral.learning_android.api.Character
import retrofit.Call
import retrofit.http.GET

interface ApiService {

    @GET("characters")
    fun getCharacters(): Call<List<Character>>
}