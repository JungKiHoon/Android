package com.example.myapplication.exam19;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountFragment extends Fragment {
    private OnItemSelectedListener mListener;
    private TextView mCountText;

    // 콜백 인터페이스
    interface OnItemSelectedListener {
        void onStartSelected();

        void onCancelSelected();
    }

    public void setCount(int count) {
        mCountText.setText(count+"");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 이 프래그먼트를 사용하는 액티비티에서 OnItemSelectedListener를 구현했는지 검사하는 코드
        try {
            mListener = (OnItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName() + "는 리스너를 구현해야 합니다");
        }
    }

    public CountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_count, container, false);
        mCountText = view.findViewById(R.id.count);
        view.findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onStartSelected();
            }
        });
        view.findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelSelected();
            }
        });
        return view;
    }
}