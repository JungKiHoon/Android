package com.example.myapplication.netwok;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment {

    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<User> dataList = new ArrayList<>();
        dataList.add(new User("Leanne", "1"));
        dataList.add(new User("Ervin", "2"));
        dataList.add(new User("Clementine", "3"));
        dataList.add(new User("Patricia", "4"));
        dataList.add(new User("kale", "5"));
        dataList.add(new User("Chelsey ", "6"));
        dataList.add(new User("Schulist", "7"));
        dataList.add(new User("Weissnat", "8"));
        dataList.add(new User("Reichert", "9"));
        dataList.add(new User("Stanton", "10"));
        dataList.add(new User("Leanne", "11"));
        dataList.add(new User("Ervin", "12"));
        dataList.add(new User("Clementine", "13"));
        dataList.add(new User("Patricia", "14"));
        dataList.add(new User("kale", "15"));
        dataList.add(new User("Chelsey ", "16"));
        dataList.add(new User("Schulist", "17"));
        dataList.add(new User("Weissnat", "18"));
        dataList.add(new User("Reichert", "19"));
        dataList.add(new User("Stanton", "20"));


        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        NetworkRecyclerAdapter adapter = new NetworkRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}