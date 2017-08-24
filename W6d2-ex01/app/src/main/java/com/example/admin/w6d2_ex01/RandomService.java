package com.example.admin.w6d2_ex01;

import com.example.admin.w6d2_ex01.Entities.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 8/22/2017.
 */

public interface RandomService {
    String BASE_URL = "https://randomuser.me/";

    @GET("api")
    Call<ApiResponse> getUsers(@Query("results") int userCount);
}
