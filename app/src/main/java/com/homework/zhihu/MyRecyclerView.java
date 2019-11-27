package com.homework.zhihu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {
    private List<AccData> dataList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView password;
        public ViewHolder(View view){
            super(view);
            username = view.findViewById(R.id.username);
            password = view.findViewById(R.id.password);
        }
    }
    public MyRecyclerView (List<AccData> dataList){
        this.dataList = dataList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        AccData accData = dataList.get(position);
        holder.username.setText(accData.getUserName());
        holder.password.setText(accData.getPassword());
    }
    @Override
    public int getItemCount(){
        return dataList.size();
    }
}