package com.example.mikki.balancediet.demopurpose;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mikki.balancediet.R;
import com.example.mikki.balancediet.demopurpose.MyIntentService;

public class PlayMusic extends Fragment {
    Button playMusic_btn, stopMusic_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playmusic, container, false);

        playMusic_btn = view.findViewById(R.id.btn_play);
        stopMusic_btn = view.findViewById(R.id.btn_stopMusic);

        playMusic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyIntentService.class);
                getActivity().startService(intent);
                //startService(intent);
            }
        });

        stopMusic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                //"hello" can be received by anyone.
                i.putExtra("mykey", "hello");
                //they just need to register Mikki to their manifest file.
                i.setAction("Stop");
                getActivity().sendBroadcast(i);
            }
        });


        return view;
    }
}
