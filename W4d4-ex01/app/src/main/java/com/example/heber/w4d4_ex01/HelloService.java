package com.example.heber.w4d4_ex01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

public class HelloService extends Service{
    
    private static final String TAG = HelloService.class.getSimpleName() + "_TAG";
    
    int startMode = START_STICKY;
    IBinder binder;
    boolean allowRebind;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return startMode;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return allowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
    }
}
