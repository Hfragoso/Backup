package com.example.admin.w6d2_ex01;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.w6d2_ex01.Entities.Result;

import java.util.List;

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder>{

    private List<Result> resultList;

    public RandomAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    public void updateDataset(List<Result> resultList){
        this.resultList = resultList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.itemNameTV.setText(buildName(result));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    private String buildName(Result result){
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(result.getName().getFirst()).append(" ").append(result.getName().getLast());
        return nameBuilder.toString();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTV;

        public ViewHolder(View itemView) {
            super(itemView);
            itemNameTV = itemView.findViewById(R.id.tv_item_name);
        }
    }
}
