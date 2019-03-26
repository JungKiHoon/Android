package com.example.myapplication.exam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Models.CardItem;
import com.example.myapplication.R;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private final List<CardItem> mDataList;
    // 클릭이 발생하는지 듣고 있는 리스너 변수
    private MyRecyclerViewListener mListener;

    public MyRecyclerAdapter(List<CardItem> dataList) {
        mDataList = dataList;
    }

    public void setOnClickListener(MyRecyclerViewListener listener) {
        mListener = listener;
    }

    // 뷰 홀더 생성하는 부분. 레이아웃 만드는 부분
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new ViewHolder(view);
    }

    // 뷰 홀더에 데이터를 넣는 부분
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem item = mDataList.get(position);
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());
        // 클릭 이벤트
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(holder.getAdapterPosition());
                }
            });
        }
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onShareButtonClicked(holder.getAdapterPosition());
            }
        });
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onLearnMoreButtonClicked(holder.getAdapterPosition());
            }
        });
    }

    // 아이템의 수
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void removeItem(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
        // size()는 list 인자의 개수를 반환해주는 메소드
        notifyItemRangeChanged(position, mDataList.size());
    }

    public void addItem(int position, CardItem item) {
        mDataList.add(position, item);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mDataList.size());
    }

    // 각각의 아이템의 레퍼런스를 저장할 뷰 홀더 클래스
    // 반드시 RecyclerView.ViewHolder를 상속해야 함
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView contents;
        Button share;
        Button more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            contents = itemView.findViewById(R.id.contents_text);
            share = itemView.findViewById(R.id.share_button);
            more = itemView.findViewById(R.id.more_button);
        }
    }

    public interface MyRecyclerViewListener {
        // 아이템 전체 부분의 클릭
        void onItemClicked(int position);

        // Share 버튼 클릭
        void onShareButtonClicked(int position);

        // Learn More 버튼 클릭
        void onLearnMoreButtonClicked(int position);
    }
}