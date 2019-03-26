package com.example.myapplication.exam;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {
    private OnColorSelectedListener mListener;

    interface OnColorSelectedListener {
        void onColorSelected(int color);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("Red", "Green", "Blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // 이 프래그먼트를 가지는 액티비티는 OnColorSelectedListener를 구현하고 있어야 한다. 그렇지 않으면 예외가 발생
            mListener = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity)context).getLocalClassName() + "는 리스너를 구현해야 합니다");
        }
    }

    // ListFragment에서 제공하는 리스트 항목을 클릭했을 때 호출되는 콜백 메소드. 콜백 될 때 4개의 인자를 전달해준다.
    // 리스트 항목에서 클릭이 발생하면 프래그먼트가 이 메소드를 호출한다!
    // 액티비티에 전달하고 싶은 내용이 있으면 이 콜백을 이용해 전달할 수 있다
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch (colorString) {
            case "Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
        }
        if(mListener != null) {
            mListener.onColorSelected(color);
        }
    }
}
