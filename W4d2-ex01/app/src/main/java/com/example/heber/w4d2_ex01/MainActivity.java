package com.example.heber.w4d2_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.heber.w4d2_ex01.api.RandomAPIService;
import com.example.heber.w4d2_ex01.injection.Injector;
import com.example.heber.w4d2_ex01.model.RandomUser;
import com.example.heber.w4d2_ex01.model.Result;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    RandomAPIService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = Injector.provideRandomAPIService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        service.getRandomUser().enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, retrofit2.Response<RandomUser> response) {
                RandomUser randomResponse = response.body();
                for(Result result : randomResponse.getResults()){
                    Log.d(TAG, "onResponse: " + result);
                }
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {

            }
        });
    }
}
