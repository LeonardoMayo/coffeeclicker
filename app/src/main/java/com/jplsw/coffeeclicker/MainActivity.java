package com.jplsw.coffeeclicker;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.jplsw.coffeeclicker.common.Statistic;
import com.jplsw.coffeeclicker.pages.ClickerFragment;
import com.jplsw.coffeeclicker.pages.GraphFragment;
import com.jplsw.coffeeclicker.pages.StatsFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.jplsw.coffeeclicker.common.Constants.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static int coffeeCount;
    private static int energyCount;

    private List<Statistic> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coffeeCount = 0;
        energyCount = 0;
        data = new ArrayList<>();

        ViewPager mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    /**
     * Persistence Methods
     */

    public void writeDataToFile() {
        Log.d(TAG, "writeDataToFile() called");

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            if (data.size() != 0) {

                for (Statistic stat :
                        data) {
                    outputStream.write(stat.toString().getBytes());
                }

            }
            Statistic current = new Statistic(20190520, coffeeCount, energyCount);
            outputStream.write(current.toString().getBytes());
            outputStream.write(current.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readDateFromFile() {
        Log.d(TAG, "readDateFromFile() called");

        File directory = this.getFilesDir();
        File file = new File(directory, FILENAME);

        Log.d(TAG, "readDateFromFile: file: " + file.toString());
    }

    /**
     * V.I.P. Methods
     */

    public static void addCoffee() {
        Log.d(TAG, "addCoffee() called");
        coffeeCount++;
        Log.d(TAG, "addCoffee: coffeeCount " + coffeeCount);
    }

    public static void addEnergyDrink() {
        Log.d(TAG, "addEnergyDrink() called");
        energyCount++;
        Log.d(TAG, "addEnergyDrink: energyCount " + energyCount);
    }

    /**
     * Getter and Setter
     */

    public static int getCoffeeCount() {
        return coffeeCount;
    }

    public static void setCoffeeCount(int coffeCount) {
        MainActivity.coffeeCount = coffeCount;
    }

    public static int getEnergyCount() {
        return energyCount;
    }

    public static void setEnergyCount(int energyCount) {
        MainActivity.energyCount = energyCount;
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i) {
                case 0:
                    return ClickerFragment.instantiate(getApplicationContext(), "com.jplsw.coffeeclicker.pages.ClickerFragment");
                case 1:
                    return StatsFragment.instantiate(getApplicationContext(), "com.jplsw.coffeeclicker.pages.StatsFragment");
                case 2:
                    return GraphFragment.instantiate(getApplicationContext(), "com.jplsw.coffeeclicker.pages.GraphFragment");
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
