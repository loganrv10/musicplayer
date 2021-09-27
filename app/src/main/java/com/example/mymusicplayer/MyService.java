package com.example.mymusicplayer;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;
import android.os.Binder;


public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    int songName;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    public void play(){
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }
    public void stop(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
    public void pause(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();;
    }

    @Override
    public IBinder onBind(Intent intent) {
        songName= intent.getIntExtra("song", 0);;
        mediaPlayer = MediaPlayer.create(this,songName);
        return new MusicBinder();
    }
    public class MusicBinder extends Binder{
        public MusicService getMusicService(){
            return MusicService.this;
        }
    }
}