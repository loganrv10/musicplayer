package com.example.mymusicplayer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiservice {
    @GET("search")
    Call<ResultsDTO>getPost (@Query("postid")String postid);


}
