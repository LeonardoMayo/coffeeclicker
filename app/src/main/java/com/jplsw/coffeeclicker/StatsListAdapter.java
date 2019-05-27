package com.jplsw.coffeeclicker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class StatsListAdapter extends RecyclerView.Adapter<StatsListAdapter.StatsListViewHolder> {

    @NonNull
    @Override
    public StatsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StatsListViewHolder statsListViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class StatsListViewHolder extends RecyclerView.ViewHolder{

        public View itemView;

        public StatsListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
