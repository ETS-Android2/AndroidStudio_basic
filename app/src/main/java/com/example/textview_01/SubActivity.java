package com.example.textview_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private TextView tv_sub;
    Button btn_musicstart, btn_musicstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent();    // mainActivity에서 보낸걸 받아옴
        String str = intent.getStringExtra("str");

        tv_sub.setText("입력한것: "+str);

        btn_musicstart = (Button)findViewById(R.id.btn_musicstart);
        btn_musicstop = (Button)findViewById(R.id.btn_musicstop);

        btn_musicstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent((getApplicationContext()),MusicService.class));
            }
        });

        btn_musicstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent((getApplicationContext()),MusicService.class));
            }
        });
    }
}