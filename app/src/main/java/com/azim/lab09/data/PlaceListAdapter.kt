package com.azim.lab09.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.azim.lab09.R
import com.azim.lab09.model.place
import org.w3c.dom.Text

// 2nd step half of step 21 () -> passes as argument -> we will pass arraylist of place and context
// 3rd step step 22
// To use
class PlaceListAdapter(private val list:ArrayList<place>,private val context: Context):
RecyclerView.Adapter<PlaceListAdapter.ViewHolder>(){

    // 1st Step no. 27
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

    }

    // Which xml file will be used to show the ViewHolder -> custom_row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // step 5step 29
        val view = LayoutInflater.from(context).inflate(R.layout.custom_row, parent,false)
        return ViewHolder(view)
    }

    // How many row are there in the recyclerView -> bergantung kepada data
    // jika ada 5 data -> 5 row
    override fun getItemCount(): Int {
        // step 4 step 28
        return list.size
    }

    // What to show in the customRow -> titleTextView, subtitleTextView
    // FindView By Id + show the data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // step 5 step 30 & 31
        var countryTextView:TextView = holder.itemView.findViewById<TextView>(R.id.titleTextview)
        var cityTextView:TextView = holder.itemView.findViewById<TextView>(R.id.subtitleTextView)

        countryTextView.text = list[position].countryName
        cityTextView.text = list[position].countryName
    }
}