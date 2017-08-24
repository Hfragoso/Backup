package com.example.heber.w4d2_ex01.injection;

import com.example.heber.w4d2_ex01.api.RandomAPIService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Injector {

    private static final String BASE_URL = "https://randomuser.me/";

    private Injector(){

    }

    public static RandomAPIService provideRandomAPIService(){
        return provideRetrofit().create(RandomAPIService.class);
    }

    private static Retrofit provideRetrofit(){
        return new Retrofit.Builder().baseUrl(BASE_URL).client(provideOkHttpClient()).addConverterFactory(provideGsonConverterFactory()).build();
    }

    private static OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    private static GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }
}
