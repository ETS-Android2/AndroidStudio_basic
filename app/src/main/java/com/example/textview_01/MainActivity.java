package com.example.textview_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    Button btn_navi;
    EditText et_save;
    String shared = "file";
    Button btn_web;
    Button btn_cumton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = findViewById(R.id.et_id);
        btn_id = findViewById(R.id.btn_id);
        et_intent = findViewById(R.id.et_intent);
        btn_intent = findViewById(R.id.btn_intent);
        btn_list = findViewById(R.id.btn_list);
        btn_navi = findViewById(R.id.btn_navi);
        et_save = findViewById(R.id.et_save);
        btn_web = findViewById(R.id.btn_web);
        btn_cumton = findViewById(R.id.btn_cumton);


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

        btn_navi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NaviActivity.class);
                startActivity(intent);
            }
        });

        // sharedPreferences는 어플 삭제시에는 사라짐
        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        String value = sharedPreferences.getString("savedval","");
        et_save.setText(value); // savedval에 저장되어 있는것을 불러오기

        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });

        btn_cumton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomNaviActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("savedval",value); //savedval 이라는 이름으로 value 저장해둠
        editor.commit();    //save

    }
}