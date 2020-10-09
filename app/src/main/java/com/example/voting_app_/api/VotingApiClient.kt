package com.example.voting_app_.api

import com.example.voting_app_.model.KingQueen
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VotingApiClient {
    private val BASE_URL = "http://voting-monywa.dsv.hoz.mybluehost.me/api/"
    var votingApiInterface: VotingApiInterface
    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        votingApiInterface = retrofit.create(VotingApiInterface::class.java)
    }
    fun getKing():Call<KingQueen>{
        return votingApiInterface.getKing()

    }
    fun getQueen():Call<KingQueen>{
        return votingApiInterface.getQueen()
    }
    fun voteKing(king_id:String,code:String):Call<String>{
        return votingApiInterface.voteKing(king_id,code)
    }
    fun voteQueen(queen_id:String,code:String):Call<String>{
        return votingApiInterface.voteQueen(queen_id,code)
    }
}