package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_exam);
        // xml에서 리사이클러뷰 가져오기
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // 레이아웃 매니저로 리니어 레이아웃 매니저를 설정
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        // 표시할 임시 데이터
        List<CardItem> datalist = new ArrayList<>();
        datalist.add(new CardItem("첫 번째 제목", "내용1"));
        datalist.add(new CardItem("두 번째 제목", "내용2"));
        datalist.add(new CardItem("세 번째 제목", "내용3"));
        datalist.add(new CardItem("네 번째 제목", "내용4"));
        datalist.add(new CardItem("다섯 번째 제목", "내용5"));
        datalist.add(new CardItem("여섯 번째 제목", "내용6"));
        datalist.add(new CardItem("일곱 번째 제목", "내용7"));
        datalist.add(new CardItem("여덟 번째 제목", "내용8"));
        // 어댑터 설정
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(datalist);
        recyclerView.setAdapter(adapter);
    }
}
