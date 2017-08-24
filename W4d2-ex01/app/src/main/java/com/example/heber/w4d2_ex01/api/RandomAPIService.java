package com.example.heber.w4d2_ex01.api;

import com.example.heber.w4d2_ex01.model.RandomUser;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomAPIService {
    @GET("api")
    Call<RandomUser> getRandomUser();
}
