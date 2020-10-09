package com.example.voting_app_.api

import com.example.voting_app_.model.KingQueen
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface VotingApiInterface {
    @GET("queen")
    fun getQueen():Call<KingQueen>
    @GET("king")
    fun getKing():Call<KingQueen>
    @FormUrlEncoded
    @POST("kingvote")
    fun voteKing(
        @Field("king_id") king_id:String,
        @Field("code")code:String
    ):Call<String>
    @FormUrlEncoded
    @POST("queenvote")
    fun voteQueen(
        @Field("queen_id") queen_id:String,
        @Field("code")code:String
    ):Call<String>
}