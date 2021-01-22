package com.example.textview_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_id;
    Button btn_id;
    EditText et_intent;
    Button btn_intent;
    private String str;
    ImageView iv_test;
    Button btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = findViewById(R.id.et_id);
        btn_id = findViewById(R.id.btn_id);
        et_intent = findViewById(R.id.et_intent);
        btn_intent = findViewById(R.id.btn_intent);
        btn_list = findViewById(R.id.btn_list);


        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("You clicked button!");
            }
        });

        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = et_intent.getText().toString();  // edit text에 입력한 text 가져오기
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str",str);     // 데이터 담기
                startActivity(intent);  // 액티비티 이동해주는 구문
            }
        });

        iv_test = (ImageView)findViewById(R.id.iv_test);
        iv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This is toast message!!", Toast.LENGTH_SHORT).show();

            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}