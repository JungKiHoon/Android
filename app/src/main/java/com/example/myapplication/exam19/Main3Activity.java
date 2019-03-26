package com.example.myapplication.exam19;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.myapplication.R;


public class Main3Activity extends AppCompatActivity implements CountFragment.OnItemSelectedListener {
    private TextView mTextView;
    private CountTask mTask;
    private CountFragment countFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mTextView = findViewById(R.id.count_text);
        // new는 새로운 인스턴스를 만드는 것. xml에 있는 프래그먼트를 가져올 때는 겟서포트프래그먼트매니저() 메서드를 통해 가져와야 한다
        countFragment = new CountFragment();
    }

    @Override
    public void onStartSelected() {
        mTask = new CountTask();
        mTask.execute();
    }

    @Override
    public void onCancelSelected() {
        mTask.cancel(true);
        mTextView.setText("0");
    }

    public class CountTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mTextView.setText(values[0] + "");
            countFragment.setCount(values[0]);
        }
    }
}