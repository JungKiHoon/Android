package com.example.myapplication.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myapplication.Models.CardItem;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewExam extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewListener {
    private static final String TAG = RecyclerViewExam.class.getSimpleName();
    private MyRecyclerAdapter mAdapter;
    List<CardItem> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_exam);

        // 리사이클러뷰 (xml에서 리사이클러뷰 가져오기)
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // 레이아웃 매니저로 레이아웃 매니저 설정
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // 데이터(표시할 임시 데이터)
        datalist = new ArrayList<>();
        datalist.add(new CardItem("첫 번째 제목", "내용1"));
        datalist.add(new CardItem("두 번째 제목", "내용2"));
        datalist.add(new CardItem("세 번째 제목", "내용3"));
        datalist.add(new CardItem("네 번째 제목", "내용4"));
        datalist.add(new CardItem("다섯 번째 제목", "내용5"));
        datalist.add(new CardItem("여섯 번째 제목", "내용6"));
        datalist.add(new CardItem("일곱 번째 제목", "내용7"));
        datalist.add(new CardItem("여덟 번째 제목", "내용8"));

        // 어댑터 생성
        mAdapter = new MyRecyclerAdapter(datalist);
        // 어댑터에 클릭리스너 설정
        mAdapter.setOnClickListener(this);
        // View에 어댑터 연결
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int position) {
        Log.d(TAG, "OnItemClicked: " + position);
    }

    @Override
    public void onShareButtonClicked(int position) {
        Log.d(TAG, "OnShareButtonClicked: " + position);
        mAdapter.addItem(position, new CardItem("추가 됨", "position: " + position));
    }

    @Override
    public void onLearnMoreButtonClicked(int position) {
        Log.d(TAG, "OnLearnMoreButtonClicked: " + position);
        mAdapter.removeItem(position);
    }
}
