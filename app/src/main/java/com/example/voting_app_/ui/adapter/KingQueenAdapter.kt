package com.example.voting_app_.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.voting_app_.R
import com.example.voting_app_.model.KingQueen
import com.example.voting_app_.model.KingQueenItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_king_queen.view.*

class KingQueenAdapter :RecyclerView.Adapter<KingQueenAdapter.KingQueenViewHolder>(){
    var kingqueenList: List<KingQueenItem> = ArrayList()
    var clickListener:ClickListener ?= null
    inner class KingQueenViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        lateinit var item:KingQueenItem
        fun bind(kingQueenItem: KingQueenItem){
            this.item = kingQueenItem
            Picasso.get().load(kingQueenItem.image).into(itemView.imageKingQueen)
            itemView.txt_name.text = kingQueenItem.name
            itemView.txt_class.text = kingQueenItem.className
        }

        override fun onClick(v: View?) {
            clickListener?.onClick(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingQueenViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_king_queen,parent,false)
        return KingQueenViewHolder(view)
    }

    override fun onBindViewHolder(holder: KingQueenViewHolder, position: Int) {
        holder.bind(kingqueenList[position])
    }

    override fun getItemCount(): Int = kingqueenList.size
    fun updateKingQueenItem(kingQueenList: List<KingQueenItem>){
        this.kingqueenList = kingQueenList
        notifyDataSetChanged()
    }
    interface ClickListener{
        fun onClick(item: KingQueenItem)
    }
    fun setOnClickListener(clickListener:ClickListener){
        this.clickListener = clickListener
    }
}