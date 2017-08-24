package com.example.heber.w3d2_ex01;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements View.OnClickListener{
    OnMessageSent callback;

    private TextView resultTV;
    private Button sendMessageBtn;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            callback = (OnMessageSent) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement onMessageSent");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        resultTV = (TextView) view.findViewById(R.id.tv_result_first);
        sendMessageBtn = (Button) view.findViewById(R.id.btn_msg_second);
        sendMessageBtn.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_msg_second:
                callback.onSendMessageFirst("hello from first");
                break;
        }
    }

    public void updateResult(String message){
        resultTV.setText(message);
    }

    public interface OnMessageSent{
        void onSendMessageFirst(String message);
    }
}