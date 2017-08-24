package com.example.heber.w2d2_ex01;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {


    public static final String PREFS_NAME = "MyAppSettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        //Writing to SP
        editor.putString("key", "some value");
        editor.commit();

        String value = settings.getString("key", "Wasn't found");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        

    }
}
