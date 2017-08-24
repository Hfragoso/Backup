package com.example.admin.w6d2_ex01;

import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.w6d2_ex01.Entities.ApiResponse;
import com.example.admin.w6d2_ex01.Entities.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RandomService service;
    private List<Result> resultList;
    private RandomAdapter randomAdapter;
    private RecyclerView userRecycler;
    private Button getUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setUpRecyclerView();
        initRandomService();
    }

    private void setUpRecyclerView() {
        resultList = new ArrayList<>(0);
        randomAdapter = new RandomAdapter(resultList);
        userRecycler.setAdapter(randomAdapter);
        userRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        userRecycler = (RecyclerView) findViewById(R.id.recycler_users);
        getUserBtn = (Button) findViewById(R.id.bt_get_users);
        getUserBtn.setOnClickListener(this);
    }

    private void initRandomService(){
        service = new Retrofit.Builder().baseUrl(RandomService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build().create(RandomService.class);
    }

    private void fetchUsers(){
        service.getUsers(100).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()){
                    resultList = response.body().getResults();
                    randomAdapter.updateDataset(resultList);
                }else{
                    Toast.makeText(MainActivity.this, "API Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_get_users:
                fetchUsers();
                break;
        }
    }
}
