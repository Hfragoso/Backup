package com.example.heber.w4d4_ex02;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.tv_result)
    TextView resultTV;

    private boolean isServiceBound;
    private BoundService boundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isServiceBound){
            unbindService(serviceConnection);
            isServiceBound = false;
        }
    }

    @OnClick(R.id.btn_print)
    public void printTimestamp(){
        if(isServiceBound){
            resultTV.setText(boundService.getTimeStamp());
        }
    }

    @OnClick(R.id.btn_stop)
    public void stopService(){
        if(isServiceBound){
            unbindService(serviceConnection);
            isServiceBound = false;
        }
        Intent intent = new Intent(this, BoundService.class);
        stopService(intent);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) iBinder;
            boundService = myBinder.getService();
            isServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isServiceBound = false;
        }
    };
}
