package com.example.myapplication.netwok;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements NetworkRecyclerAdapter.NetworkRecyclerClickListener {
    private static final String TAG = NetworkExamActivity.class.getSimpleName();
    ArrayList<User> mDataList = new ArrayList<>();

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

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        NetworkRecyclerAdapter adapter = new NetworkRecyclerAdapter();
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonplaceholderService service = retrofit.create(JsonplaceholderService.class);
        /*
        service.listPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.code() == 200) {
                    List<Photo> photoList = response.body();
                    Log.d(TAG, "onResponse" + photoList);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        }); */

        service.listUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> userList = response.body();
                Log.d(TAG, "-onResponse-" + userList);
                adapter.setmItems(userList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

        /*
        mDataList.add(new User("Leanne", "1", "title1", "todo1"));
        mDataList.add(new User("Ervin", "2", "title2", "todo2"));
        mDataList.add(new User("Clementine", "3", "title3", "todo3"));
        mDataList.add(new User("Patricia", "4", "title4", "todo4"));
        mDataList.add(new User("kale", "5", "title5", "todo5"));
        mDataList.add(new User("Chelsey ", "6", "title6", "todo6"));
        mDataList.add(new User("Schulist", "7", "title7", "todo7"));
        mDataList.add(new User("Weissnat", "8", "title8", "todo8"));
        mDataList.add(new User("Reichert", "9", "title9", "todo9"));
        mDataList.add(new User("Stanton", "10", "title10", "todo10"));
        mDataList.add(new User("Leanne", "11", "title11", "todo11"));
        mDataList.add(new User("Ervin", "12", "title12", "todo12"));
        mDataList.add(new User("Clementine", "13", "title13", "todo13"));
        mDataList.add(new User("Patricia", "14", "title14", "todo14"));
        mDataList.add(new User("kale", "15", "title15", "todo15"));
        mDataList.add(new User("Chelsey ", "16", "title16", "todo16"));
        mDataList.add(new User("Schulist", "17", "title17", "todo17"));
        mDataList.add(new User("Weissnat", "18", "title18", "todo18"));
        mDataList.add(new User("Reichert", "19", "title19", "todo19"));
        mDataList.add(new User("Stanton", "20", "title20", "todo20"));
        */
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(getContext(), ViewPagerActivity.class);
        startActivity(intent);
    }
}