package com.example.myapplication.netwok;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class NetworkRecyclerAdapter extends RecyclerView.Adapter<NetworkRecyclerAdapter.ViewHolder>{
    private  List<User> mItems = new ArrayList<User>();
    private NetworkRecyclerClickListener mListener;

    public void setmItems(List<User> items) {
        mItems = items;
    }

    public void setOnClickListener(NetworkRecyclerClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User item = mItems.get(i);
        viewHolder.name.setText(item.getName());
        viewHolder.id.setText(item.getId());
        if(mListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(viewHolder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            id = itemView.findViewById(R.id.user_id);
        }
    }
    public interface NetworkRecyclerClickListener {
        void onItemClicked(int position);
    }
}