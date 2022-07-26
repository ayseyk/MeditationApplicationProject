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
    }

    private fun getStories(){
        val s1 = Story(R.drawable.s1, "Falling Leaves","Cum sociis natoque",
            "For delivering the project to us, please create a git repo without using " +
                    "Meditopia name in the project and repository and then please send us the link to repository via email.")
        val s2 = Story(R.drawable.s2, "Cozy Campfire","Donec pede justo","Given the design and the application behaviour described in this document, you are asked to create an\n" +
                "Android app using Android Studio and Kotlin to have a basic understanding of your programming\n" +
                "capabilities as an Android Developer.")
        val s3 = Story(R.drawable.s3, "Night Call","Curabitur ullamcorper",
            "Please be informed that this case and the dataset are protected with copyright laws. We kindly ask you to keep the case, the dataset, and any\n" +
                "related information, such as your responses, confidential, by not disclosing or sharing them with any third parties or publishing them in any platform.")
        val s4 = Story(R.drawable.s4, "The Flower Garden ","Maecenas tempus","Given the design and the application behaviour described in this document, you are asked to create an\n" +
                "Android app using Android Studio and Kotlin to have a basic understanding of your programming\n" +
                "capabilities as an Android Developer.")
        val s5 = Story(R.drawable.s5, "The Time Machine","Etiam sit amet orci","Given the design and the application behaviour described in this document, you are asked to create an\n" +
                "Android app using Android Studio and Kotlin to have a basic understanding of your programming\n" +
                "capabilities as an Android Developer.")
        val s6 = Story(R.drawable.s6, "1001 Nights","Sed fringilla mauris sit","1,001 Nights, also known as The Thousand and One Nights or Arabian Nights, is a collection of Middle Eastern and South Asian folk tales that were originally published together during the Islamic Golden Age. The stories — from historical tales to tragic romances to comedies — were collected over many centuries by a huge range of scholars and authors. Read below to find ten of the most standout stories.")

        val storyList = arrayListOf(s1,s2,s3,s4,s5,s6)
        stories.value = storyList
    }
}