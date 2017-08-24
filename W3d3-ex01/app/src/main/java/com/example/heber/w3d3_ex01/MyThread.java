package com.example.heber.w3d3_ex01;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by heber on 8/2/2017.
 */

public class MyThread extends Thread{

    Handler handler;

    public MyThread(){
        // he the context is of where you instance MyThread
        //if you want to refresh the activity, you have to
        //instance the handler here
        //handler = new Handler
    }

    @Override
    public void run() {
        Looper.prepare(); // This attaches the Message Queue
        handler = new Handler();
        Looper.loop(); // Is looping for message.
    }
}
