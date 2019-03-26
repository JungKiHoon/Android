package com.example.myapplication.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 넘어온 값을 화면에 표시
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        mMessageTextView = findViewById(R.id.message_edit_text);
        mMessageTextView.setText(age + "살" + name);
        findViewById(R.id.result_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", mMessageTextView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void moveThirdActivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
