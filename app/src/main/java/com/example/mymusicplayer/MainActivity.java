package com.example.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageButton idBtnSearch;
    ProgressBar progressBar;
     List<ResultsDTO> arrayList ;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MusicBinder musicBinder = (MusicService.MusicBinder) iBinder;
            MusicService musicService = musicBinder.getMusicService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycleView);
        idBtnSearch = findViewById(R.id.idBtnSearch);
        progressBar = findViewById(R.id.progressBar);
        idBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApi();
            }
        });
    }

    private void callApi() {
        Apiservice apiservice = Network.getRetrofitInstance().create(Apiservice.class);
        apiservice.getPost("postid").enqueue(new Callback<ResultsDTO>() {
            @Override
            public void onResponse(Call<ResultsDTO> call, Response<ResultsDTO> response) {
                arrayList = (List<ResultsDTO>) response.body();
                setRecycleView();

            }

            @Override
            public void onFailure(Call<ResultsDTO> call, Throwable t) {

            }
        });
    }

    private void setRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        SongAdapter songAdapter = new SongAdapter(arrayList);
        recyclerView.setAdapter(songAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}