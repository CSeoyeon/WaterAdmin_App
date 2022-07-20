package com.example.wateradmin.ui.connection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://gausslab-hq.iptime.org:8080/water-api/v1/";
    @GET("water-price")
    Call<List<Results>> getRegions();




}
