package com.example.textview_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = (ListView)findViewById(R.id.list);

        List<String> data = new ArrayList<>();  // list view에 넣을 데이터

        // data를 연결해주는 중간 다리 역할하는 adapter && android에서 기본 제공하는 UI디자인 사용하기
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        for(int i=0;i<10;i++){
            data.add("This is list number "+(i+1));
        }
        adapter.notifyDataSetChanged(); // 마지막에 data에 바뀐것을 저장!
    }
}