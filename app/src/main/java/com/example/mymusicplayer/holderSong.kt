package com.example.mymusicplayer

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SongHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var imageSong: ImageView? = null
    private var songName: TextView? = null
    private var artistName: TextView? = null
    private var btnPlay: Button? = null
    private val btnPause: Button? = null
    private val btnDelete: Button? = null
    private fun initView(itemView: View) {
        imageSong = itemView.findViewById(R.id.imageSong)
        songName = itemView.findViewById(R.id.songName)
        artistName = itemView.findViewById(R.id.artistName)
        btnPlay = itemView.findViewById()
    }

    init {
        initView(itemView)
    }
}
