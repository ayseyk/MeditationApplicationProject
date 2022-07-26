package com.example.meditation.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.R
import com.example.meditation.model.Meditation
import com.example.meditation.model.Story
import kotlinx.android.synthetic.main.item_story.view.*

class StoryListAdapter(private val storyList : ArrayList<Story>) : RecyclerView
.Adapter<StoryListAdapter.StoryViewHolder>() {

    class StoryViewHolder(var view : View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun updateStoryList(newStoryList : List<Story>){
        storyList.clear()
        storyList.addAll(newStoryList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.view.tvStoryName.text = storyList[position].Name
        holder.view.tvStoryDesc.text = storyList[position].Description
        holder.view.storyImg.setBackgroundResource(storyList[position].Image)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }
}