package com.example.myapplication.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class Exam12Activity extends AppCompatActivity {
    private TextView mLevelText;
    private TextView mScoreText;
    private int mLevel = 0;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam12);
        mLevelText = findViewById(R.id.level_text);
        mScoreText = findViewById(R.id.score_text);

        if(savedInstanceState == null) {

        } else {
            mLevel = savedInstanceState.getInt("STATE_LEVEL");
            mScore = savedInstanceState.getInt("STATE_SCORE");
            mLevelText.setText("레벨 : " + mLevel);
            mScoreText.setText("점수 : " + mScore);
        }
    }

    public void onLevelUp(View view) {
        mLevel++;
        mLevelText.setText("레벨 : " + mLevel);
    }

    public void onScoreUp(View view) {
        mScore += 100;
        mScoreText.setText("점수 : " + mScore);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("STATE_SCORE", mScore);
        outState.putInt("STATE_LEVEL", mLevel);
    }
}
