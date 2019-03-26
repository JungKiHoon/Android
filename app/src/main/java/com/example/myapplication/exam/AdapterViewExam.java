package com.example.myapplication.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.Models.Weather;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AdapterViewExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "27도", "비"));
        data.add(new Weather("대구", "30도", "흐림"));
        data.add(new Weather("부천", "29도", "맑음"));
        data.add(new Weather("부산", "32도", "흐림"));
        data.add(new Weather("전주", "28도", "비"));
        data.add(new Weather("인천", "27도", "흐림"));
        data.add(new Weather("안양", "28도", "맑음"));
        data.add(new Weather("천안", "29도", "맑음"));
        // 어댑터
        MyFirstAdapter adapter = new MyFirstAdapter(data);
        // 뷰
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
