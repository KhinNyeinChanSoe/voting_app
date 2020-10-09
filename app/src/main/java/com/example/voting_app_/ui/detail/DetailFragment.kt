package com.example.voting_app_.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.voting_app_.R
import com.example.voting_app_.api.VotingApiClient
import com.example.voting_app_.model.KingQueenItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_king_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var item: KingQueenItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item = args.item
        txt_detailName.text = item.name
        txt_detailClass.text = item.className
        Picasso.get().load(item.image).placeholder(R.drawable.ic_launcher_background)
            .into(img_voteDetail)
        btn_submit.setOnClickListener {
            var apiClient = VotingApiClient()
            var apiCall = apiClient.voteKing(item.id!!, edt_Code.text.toString())
            apiCall.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    txt_result.text = response.body().toString()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("ERROR>>>",t.toString())
                }
            })
        }
    }

}