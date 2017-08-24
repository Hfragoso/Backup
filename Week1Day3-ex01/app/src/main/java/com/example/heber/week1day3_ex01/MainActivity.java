package com.example.heber.week1day3_ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    public static final String MAIN_ACTIVITY_EXTRA = "com.example.heber.week1day3_ex01.MAIN_ACTIVITY_EXTRA";

    /**
     * Javadoc comment (this generates documentation)
     * @param savedInstanceState
     *
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this is java context... not android
        System.out.println("to print");


        //to the android console
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void startSecondActivity(View view) {
        String  message = "Hello from MainActivity";

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, message);
        startActivity(intent);

    }
}
