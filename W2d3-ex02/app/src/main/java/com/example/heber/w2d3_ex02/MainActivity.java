package com.example.heber.w2d3_ex02;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputET;
    private TextView resultTV;
    private Button saveBTN;
    private Button readBTN;

    private File myExternalFile;
    private String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = (EditText) findViewById(R.id.et_input);
        resultTV = (TextView) findViewById(R.id.tv_result);
        saveBTN = (Button) findViewById(R.id.btn_save);
        saveBTN.setOnClickListener(this);
        readBTN = (Button) findViewById(R.id.btn_read);
        readBTN.setOnClickListener(this);

        if(!isExternalStorageAvailable() || isExternalStorageReadOnly())
            saveBTN.setEnabled(false);
        else{
            String fileName = "sample.txt";
            String filePath = "MyFileStorage";
            myExternalFile = new File(getExternalFilesDir(filePath), fileName);
        }

    }

    private static boolean isExternalStorageReadOnly(){
        String externalStorageState = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState))
            return true;
        else
            return false;
    }

    private static boolean isExternalStorageAvailable(){
        String externalStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(externalStorageState);
    }

    private void saveFile(){
        try{
            FileOutputStream outputStream = new FileOutputStream(myExternalFile);
            outputStream.write(inputET.getText().toString().getBytes());
            outputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        inputET.setText("");
        Toast.makeText(this, "File saved.", Toast.LENGTH_SHORT).show();
    }

    private void readFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream(myExternalFile);
            DataInputStream inputStream = new DataInputStream(fileInputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String readLine;
            while ((readLine = reader.readLine()) != null){
                data += readLine;
            }

            fileInputStream.close();
            inputStream.close();
            reader.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        resultTV.setText(String.format(getString(R.string.lbl_result_holder), data));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save:
                saveFile();
                break;
            case R.id.btn_read:
                readFile();
                break;
        }
    }
}
