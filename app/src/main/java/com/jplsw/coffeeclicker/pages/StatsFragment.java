package com.jplsw.coffeeclicker.pages;

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

import com.jplsw.coffeeclicker.MainActivity;
import com.jplsw.coffeeclicker.R;
import com.jplsw.coffeeclicker.StatsListAdapter;
import com.jplsw.coffeeclicker.common.Statistic;

import java.util.List;

public class StatsFragment extends Fragment {
    private static final String TAG = "StatsFragment";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Statistic> mDataset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page_statistic, container, false);

        mDataset = ((MainActivity) getActivity()).getData();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]");

        if (((MainActivity) getActivity()).getData() != null){
            recyclerView = view.findViewById(R.id.statsRecyclerView);

            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            mAdapter = new StatsListAdapter();
            recyclerView.setAdapter(mAdapter);

        }

    }
}
