package com.example.meditation.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meditation.R
import com.example.meditation.model.Meditation
import com.example.meditation.model.Story
import com.example.meditation.util.Util
import com.example.meditation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private val meditationListAdapter = MeditationListAdapter(arrayListOf())
    private val storyListAdapter = StoryListAdapter(arrayListOf())

    private val meditationListObserver = Observer<List<Meditation>>{ list->
        list?.let{
            meditationListAdapter.updateMeditationList(it)
        }
    }

    private val storyListObserver = Observer<List<Story>>{ list->
        list?.let{
            storyListAdapter.updateStoryList(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.run {
            meditations.observe(viewLifecycleOwner, meditationListObserver)
            stories.observe(viewLifecycleOwner, storyListObserver)
            refreshMeditationList()
            refreshStoryList()
        }

        rcwMeditations.adapter = meditationListAdapter
        rcwStories.adapter = storyListAdapter

        val prefs = Util(requireContext())
        tvBanner.text = resources.getString(R.string.bannerText, prefs.getUserName())
    }
}