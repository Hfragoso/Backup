package com.example.heber.w1d4_ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY_EXTRA = "com.example.heber.w1d4_ex01.MAIN_ACTIVITY_EXTRA";
    EditText name;
    EditText lastName;
    EditText email;
    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.user_name);
        lastName = (EditText) findViewById(R.id.user_last_name);
        email = (EditText) findViewById(R.id.user_email);
        userName = (EditText) findViewById(R.id.user_username);
    }

    public void shareInfo(View view) {
        String nameValue = name.getText().toString();
        String lastNameValue = lastName.getText().toString();
        String emailValue = email.getText().toString();
        String userNameValue = userName.getText().toString();
        User user = new User(nameValue, lastNameValue, emailValue, userNameValue);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, user);
        startActivity(intent);

    }
}
