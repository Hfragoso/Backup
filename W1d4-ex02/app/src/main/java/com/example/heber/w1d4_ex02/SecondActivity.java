package com.example.heber.w1d4_ex02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText et_message;

    public static final String RESULT_EXTRA = "com.example.heber.w1d4_ex02.RESULT_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et_message = (EditText) findViewById(R.id.et_message);
    }

    public void sendResult(View view) {
        String message = et_message.getText().toString();
        Intent data = new Intent();
        data.putExtra(RESULT_EXTRA, message);
        setResult(MainActivity.REQUEST_CODE, data);
        finish();
    }
}
