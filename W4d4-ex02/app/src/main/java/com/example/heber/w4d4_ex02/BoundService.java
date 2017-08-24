package com.example.heber.w4d4_ex02;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Chronometer;

public class BoundService extends Service{
    private static final String TAG = BoundService.class.getSimpleName();

    private IBinder binder = new MyBinder();
    private Chronometer chronometer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        chronometer = new Chronometer(this);
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return binder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind: ");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return true;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        chronometer.stop();
    }

    public String getTimeStamp(){
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        return String.valueOf(elapsedMillis);
    }

    public class MyBinder extends Binder {
        BoundService getService(){
            return BoundService.this;
        }
    }
}
