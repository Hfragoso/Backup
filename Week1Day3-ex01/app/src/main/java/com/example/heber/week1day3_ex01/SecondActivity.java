package com.example.heber.week1day3_ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null){
            String message = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA);

            Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
