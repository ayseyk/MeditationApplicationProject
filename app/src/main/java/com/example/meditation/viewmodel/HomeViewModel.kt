package com.example.meditation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.meditation.R
import com.example.meditation.model.Meditation
import com.example.meditation.model.Story

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val meditations by lazy { MutableLiveData<List<Meditation>>() }
    val stories by lazy { MutableLiveData<List<Story>>() }
//    val loadError by lazy { MutableLiveData<Boolean>()}
//    val loading by lazy { MutableLiveData<Boolean>()}

    fun refreshMeditationList(){
        getMeditations()
    }
    fun refreshStoryList(){
        getStories()
    }


    private fun getMeditations(){
        val m1 = Meditation(R.drawable.m1,"Sleep Well","A dreamy sleep")
        val m2 = Meditation(R.drawable.m2,"Deep Sleep","Restful nights")
        val m3 = Meditation(R.drawable.m2,"Bedtime Imagery","Surrender to Sleep")

        val meditationList = arrayListOf(m1,m2,m3)
        meditations.value = meditationList
//        loadError.value = false
//        loading.value = true


    }
    private fun getStories(){
        val s1 = Story(null, "Falling Leaves","Cum sociis natoque")
        val s2 = Story(null, "Cozy Campfire","Donec pede justo")
        val s3 = Story(null, "Night Call","Curabitur ullamcorper")
        val s4 = Story(null, "The Flower Garden ","Maecenas tempus")
        val s5 = Story(null, "The Time Machine","Etiam sit amet orci")
        val s6 = Story(null, "1001 Nights","Sed fringilla mauris sit")

        val storyList = arrayListOf(s1,s2,s3,s4,s5,s6)
        stories.value = storyList
    }
}