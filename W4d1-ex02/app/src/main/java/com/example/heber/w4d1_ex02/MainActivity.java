package com.example.heber.w4d1_ex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.heber.w4d1_ex02.api.RandomAPIService;
import com.example.heber.w4d1_ex02.model.RandomUser;
import com.example.heber.w4d1_ex02.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private static final String BASE_URL = "https://randomuser.me";

    private RandomAPIService service;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(RandomAPIService.class);

        service.getRandomUser().enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, Response<RandomUser> response) {
                RandomUser responseAPI = response.body();
                for(Result result : responseAPI.getResults()){
                    Log.d(TAG, "onResponse: " + result);
                }
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {

            }
        });
    }
}
