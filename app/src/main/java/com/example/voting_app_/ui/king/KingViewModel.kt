package com.example.voting_app_.ui.king

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.voting_app_.api.VotingApiClient
import com.example.voting_app_.model.KingQueen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingViewModel : ViewModel() {

   private var kingModel:MutableLiveData<KingQueen> = MutableLiveData()
    fun getKing():MutableLiveData<KingQueen> = kingModel
    fun loadKing(){
        var apiClient = VotingApiClient()
        var apiCall = apiClient.getKing()
        apiCall.enqueue(object : Callback<KingQueen> {
            override fun onResponse(call: Call<KingQueen>, response: Response<KingQueen>) {
                kingModel.value = response.body()
                Log.d("RESULT", response.body().toString())
            }

            override fun onFailure(call: Call<KingQueen>, t: Throwable) {
                Log.d("ERROR>>>>>", t.toString())
            }

        })
    }
}