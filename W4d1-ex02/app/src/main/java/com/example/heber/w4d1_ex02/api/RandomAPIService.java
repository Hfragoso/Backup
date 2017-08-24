package com.example.heber.w4d1_ex02.api;

import com.example.heber.w4d1_ex02.model.RandomUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by heber on 8/7/2017.
 */

public interface RandomAPIService {
    //https://randomuser.me/api
    @GET("api")
    Call<RandomUser> getRandomUser();

    //https://randomuser.me/api?results=count
    @GET("api")
    Call<RandomUser> getRandomUser(@Query("results")int count);

    //https://randomuser.me/api/{id}/items
    @GET("api/{id}/user")
    Call<RandomUser> getRandomUser(@Path("id") String id);
}