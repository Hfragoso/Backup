package com.example.heber.w2d3_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    private TextView resultTV;
    private EditText inputET;

    private String data;
    private String file = "myfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = (TextView) findViewById(R.id.tv_result);
        inputET = (EditText) findViewById(R.id.et_input);
    }

    public void saveFile(View view){
        data = inputET.getText().toString();
        try{
            FileOutputStream outputStream = openFileOutput(file, MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(MainActivity.this, "File saved.", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(View view){
        try{
            FileInputStream inputStream = openFileInput(file);
            int count;
            String temp = "";
            while ((count = inputStream.read()) != -1){
                temp = temp + Character.toString((char) count);
            }
            resultTV.setText(String.format(getString(R.string.lbl_result_holder),temp));
            Toast.makeText(this, "File read", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
