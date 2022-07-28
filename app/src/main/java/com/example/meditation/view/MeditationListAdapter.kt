package com.example.meditation.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.R
import com.example.meditation.model.Meditation
import kotlinx.android.synthetic.main.item_meditation.view.*

class MeditationListAdapter(private val meditationList : ArrayList<Meditation>) : RecyclerView
.Adapter<MeditationListAdapter.MeditationViewHolder>() {

    class MeditationViewHolder(var view : View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun updateMeditationList(newMeditationList : List<Meditation>){
        meditationList.clear()
        meditationList.addAll(newMeditationList)
        notifyDataSetChanged() //refresh recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_meditation, parent, false)
        return MeditationViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeditationViewHolder, position: Int) {
        holder.view.tvMeditationName.text = meditationList[position].name
        holder.view.tvMeditationDesc.text = meditationList[position].description
        holder.view.meditationImg.setBackgroundResource(meditationList[position].image)
    }

    override fun getItemCount(): Int {
        return meditationList.size
    }
}