package com.example.mymusicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class SongAdapter extends RecyclerView.Adapter<SongHolder> {
   List<ResultsDTO> arrayList ;


    public SongAdapter(List<ResultsDTO> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, int position) {
      ResultsDTO resultsDTO = arrayList.get(position);
      holder.setData(resultsDTO);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
