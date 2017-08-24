package com.example.admin.w5d2_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyFragment myFragment;

    Button sendMessageBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessageBt = (Button) findViewById(R.id.bt_send_message);
        sendMessageBt.setOnClickListener(this);

        if(myFragment == null){
            myFragment = new MyFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_send_message:
                postToFragment();
                break;
        }
    }

    private void postToFragment() {
        EventBus.getDefault().post(new HelloWorldEvent("Hello Event Bus from activity"));
    }
}
