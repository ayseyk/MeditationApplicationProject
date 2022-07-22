package com.example.meditation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meditation.R
import com.example.meditation.model.Meditation
import com.example.meditation.model.Story
import com.example.meditation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private val meditationListAdapter= MeditationListAdapter(arrayListOf())
    private val storyListAdapter= StoryListAdapter(arrayListOf())

    private val MeditationListObserver = Observer<List<Meditation>>{list->
        list?.let{
            meditationListAdapter.updateMeditationList(it)
        }
    }
    private val StoryListObserver = Observer<List<Story>>{ list->
        list?.let{
            storyListAdapter.updateStoryList(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.meditations.observe(viewLifecycleOwner, MeditationListObserver)
        viewModel.stories.observe(viewLifecycleOwner, StoryListObserver)
        viewModel.refreshMeditationList()
        viewModel.refreshStoryList()


        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rcwMeditations.layoutManager = linearLayoutManager
        rcwMeditations.adapter = meditationListAdapter

        rcwStories.apply{
            layoutManager = GridLayoutManager(context,2)
            adapter = storyListAdapter
        }

    }

}