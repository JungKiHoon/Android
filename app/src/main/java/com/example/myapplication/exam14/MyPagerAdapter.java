package com.example.myapplication.exam14;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mDada;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        mDada = new ArrayList<>();
        mDada.add(new ColorFragment1());
        mDada.add(new ItemFragment());
        mDada.add(new PlusOneFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return mDada.get(i);
    }

    @Override
    public int getCount() {
        return mDada.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position + " 번째";
    }
}