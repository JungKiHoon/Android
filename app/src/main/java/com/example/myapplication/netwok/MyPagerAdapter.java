package com.example.myapplication.netwok;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mData;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        mData = new ArrayList<>();
        mData.add(new PhotoFragment());
        mData.add(new TodoFragment());
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "photos";
        else
            return "todos";
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
