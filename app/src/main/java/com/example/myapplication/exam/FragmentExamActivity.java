package com.example.myapplication.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;

public class FragmentExamActivity extends AppCompatActivity implements ColorListFragment.OnColorSelectedListener {
    private BColorFragment mBColorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exam);

        mBColorFragment = (BColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_BColor);
    }

    @Override
    public void onColorSelected(int color) {
        mBColorFragment.setColor(color);
    }

    /*
    public void change(View view) {
        ColorFragment fragment = new ColorFragment();
        int red = new Random().nextInt(256);
        int green = new Random().nextInt(256);
        int blue = new Random().nextInt(256);
        fragment.setColor(Color.rgb(red, green, blue));
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }*/
}