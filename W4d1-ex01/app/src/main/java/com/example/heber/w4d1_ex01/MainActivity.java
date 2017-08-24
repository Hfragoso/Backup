package com.example.heber.w4d1_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.heber.w4d1_ex01.model.RandomUser;
import com.example.heber.w4d1_ex01.model.Result;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new OkHttpClient();
    }


    @Override
    protected void onResume() {
        super.onResume();
        final Request request = new Request.Builder().url("https://randomuser.me/api").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                RandomUser responseRandomUser = gson.fromJson(json, RandomUser.class);
                for(Result result : responseRandomUser.getResults()){
                    Log.d(TAG, "onResponse: " + result);
                }
            }
        });
    }
}
