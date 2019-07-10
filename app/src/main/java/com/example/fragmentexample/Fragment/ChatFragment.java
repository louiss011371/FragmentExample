package com.example.fragmentexample.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentexample.R;


public class ChatFragment extends Fragment {

    private TextView chatView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)  {
        super.onViewCreated(view, savedInstanceState);

    //initialize your view here for use view.findViewById("your view id")
        chatView = view.findViewById(R.id.chatView);
        chatView.setTextColor(Color.parseColor("#FF0000"));
        chatView.setText("This is chat ");
        chatView.setTextSize(30);

    }
}