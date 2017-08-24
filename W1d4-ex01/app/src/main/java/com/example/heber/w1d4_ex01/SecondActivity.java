package com.example.heber.w1d4_ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv_name;
    TextView tv_lastName;
    TextView tv_email;
    TextView tv_userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_name = (TextView) findViewById(R.id.tv_user_name);
        tv_lastName = (TextView) findViewById(R.id.tv_user_lastName);
        tv_email = (TextView) findViewById(R.id.tv_user_email);
        tv_userName = (TextView) findViewById(R.id.tv_user_userName);

        loadFieldsValues();
    }

    public void loadFieldsValues(){
        Intent intent = getIntent();
        if(intent != null){
            User user = intent.getParcelableExtra((MainActivity.MAIN_ACTIVITY_EXTRA));

            tv_name.setText(user.getName());
            tv_lastName.setText(user.getLastName());
            tv_email.setText(user.getEmail());
            tv_userName.setText(user.getUserName());
        }
    }

}
