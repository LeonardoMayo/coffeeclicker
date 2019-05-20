package com.jplsw.coffeeclicker.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jplsw.coffeeclicker.MainActivity;
import com.jplsw.coffeeclicker.R;
import java.util.Calendar;
import java.util.Date;

public class ClickerFragment extends Fragment {
    private static final String TAG = "ClickerFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page_clicker, container, false);

        ImageButton addCoffeeButton = view.findViewById(R.id.clickCoffee);
        addCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                ((MainActivity) getActivity()).addCoffee();
            }
        });

        ImageButton addEnergyButton = view.findViewById(R.id.clickEnergy);
        addEnergyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                ((MainActivity) getActivity()).addEnergyDrink();
            }
        });

        displayCurrentDateAtTop((TextView) view.findViewById(R.id.dateTextView));

        return view;
    }

    private void displayCurrentDateAtTop(TextView text) {

        Date currentdate = Calendar.getInstance().getTime();
        text.setText("Today, " + currentdate.toString());

    }
}
