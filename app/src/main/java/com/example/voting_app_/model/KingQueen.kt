package com.example.voting_app_.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class KingQueen(
	@field:SerializedName("data")
	val dataList: List<KingQueenItem?>? = null
)
@Parcelize
data class KingQueenItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("vote_time_status")
	val voteTimeStatus: Int? = null,

	@field:SerializedName("class_name")
	val className: String? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
):Parcelable
