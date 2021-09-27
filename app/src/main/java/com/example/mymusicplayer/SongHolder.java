package com.example.mymusicplayer;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SongHolder extends RecyclerView.ViewHolder {
   private ImageView imageSong;
   private TextView songName,artistName;
   private Button btnPlay,btnPause,btnDelete;

    public SongHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        imageSong  = itemView.findViewById(R.id.imageSong);
        songName = itemView.findViewById(R.id.songName);
        artistName = itemView.findViewById(R.id.artistName);
        btnPlay = itemView.findViewById(R.id.btnPlay);
        btnPause = itemView.findViewById(R.id.btnPause);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }

    public void setData(ResponseDTO responseDTO){
        Glide.with(imageSong).load(responseDTO.getResults()).into(imageSong);
    }
}
