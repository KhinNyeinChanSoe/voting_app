package com.example.voting_app_.ui.queen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.voting_app_.api.VotingApiClient
import com.example.voting_app_.model.KingQueen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenViewModel : ViewModel() {
    private var queenModel: MutableLiveData<KingQueen> = MutableLiveData()
    fun getQueen(): MutableLiveData<KingQueen> = queenModel
    fun loadQueen() {
        var apiClient = VotingApiClient()
        var apiCall = apiClient.getQueen()
        apiCall.enqueue(object : Callback<KingQueen> {
            override fun onResponse(call: Call<KingQueen>, response: Response<KingQueen>) {
                queenModel.value = response.body()
            }

            override fun onFailure(call: Call<KingQueen>, t: Throwable) {
                Log.d("ERROR>>>>>", t.toString())
            }

        })
    }
}