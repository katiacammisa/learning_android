package com.austral.learning_android.apiManager

import android.content.Context
import android.widget.Toast
import com.austral.learning_android.R
import com.austral.learning_android.api.Character
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import javax.inject.Inject

class ApiServiceImpl @Inject constructor() {

    fun getCharacters(context: Context, onSuccess: (List<Character>) -> Unit, onFail: () -> Unit, loadingFinished: () -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(
                context.getString(R.string.characters_url)
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        val service: ApiService = retrofit.create(ApiService::class.java)

        val call: Call<List<Character>> = service.getCharacters()

        call.enqueue(object : Callback<List<Character>> {
            override fun onResponse(response: Response<List<Character>>?, retrofit: Retrofit?) {
                loadingFinished()
                if(response?.isSuccess == true) {
                    val characters: List<Character> = response.body()
                    onSuccess(characters)
                } else {
                    onFailure(Exception("Bad request"))
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Can't get characters", Toast.LENGTH_SHORT).show()
                onFail()
                loadingFinished()
            }
        })
    }
}