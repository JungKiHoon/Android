package com.example.myapplication.netwok;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.R;

public class NetworkExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_exam);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UsersFragment usersFragment = new UsersFragment();
        fragmentTransaction.add(R.id.fragment_container, usersFragment);
        fragmentTransaction.commit();
    }
}