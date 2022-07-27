package com.example.meditation.view

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.meditation.R
import com.example.meditation.databinding.FragmentMediaBinding
import com.example.meditation.model.Story
import kotlinx.android.synthetic.main.fragment_media.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MediaFragment : Fragment() {

    private var story : Story? = null
    private lateinit var dataBinding : FragmentMediaBinding
    private lateinit var mediaPlayer: MediaPlayer
    private val audioUrl = "https://d2r0ihkco3hemf.cloudfront.net/bgxupraW2spUpr_y2.mp3"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_media, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            story = MediaFragmentArgs.fromBundle(it).story
        }

        dataBinding.story = story

        initializeViews()
        initializeEvents(view)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun initializeViews() {
        val calendar = Calendar.getInstance()
        val days = resources.getStringArray(R.array.days)
        tvDate.text = SimpleDateFormat("dd/MM/yyyy").format(Date()) +", "+ days[calendar.get(Calendar.DAY_OF_WEEK)-1]
    }

    private fun initializeEvents(view : View) {
        btnBack.setOnClickListener {
            val action = MediaFragmentDirections.actionMediaToHome()
            Navigation.findNavController(view).navigate(action)
        }

        btnPlay.setOnClickListener {
            btnPlay.visibility = View.GONE
            btnPause.visibility = View.VISIBLE
            shadow.visibility = View.VISIBLE
            playAudio()
        }

        btnPause.setOnClickListener {
            btnPause.visibility = View.GONE
            btnPlay.visibility = View.VISIBLE
            shadow.visibility = View.GONE
            pauseAudio()
        }
    }

    private fun pauseAudio() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }
    }

    private fun playAudio(){
        mediaPlayer = MediaPlayer()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource(audioUrl)
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}