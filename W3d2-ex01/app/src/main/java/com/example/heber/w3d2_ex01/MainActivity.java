package com.example.heber.w3d2_ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.OnMessageSent, FragmentB.OnMessageSent{

    private FragmentA firstFragment;
    private FragmentB secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(firstFragment == null){
            firstFragment = new FragmentA();
        }
        if(secondFragment == null){
            secondFragment = new FragmentB();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.first_container, firstFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.second_container, secondFragment).commit();
    }

    @Override
    public void onSendMessageFirst(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        secondFragment.updateResult(message);
    }

    @Override
    public void onSendMessageSecond(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        firstFragment.updateResult(message);
    }
}
