package com.jplsw.coffeeclicker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.jplsw.coffeeclicker.pages.ClickerFragment;
import com.jplsw.coffeeclicker.pages.GraphFragment;
import com.jplsw.coffeeclicker.pages.StatsFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static int coffeeCount;
    private static int energyCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coffeeCount = 0;
        energyCount = 0;

        ViewPager mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    /**
        Persistence Methods
     */

    private void writeDataToFile(){

    }

    private void readDateFromFile(){

    }

    /**
        V.I.P. Methods
     */

    public static void addCoffee(){
        Log.d(TAG, "addCoffee() called");
        coffeeCount++;
        Log.d(TAG, "addCoffee: coffeeCount " + coffeeCount);
    }

    public static void addEnergyDrink(){
        Log.d(TAG, "addEnergyDrink() called");
        energyCount++;
        Log.d(TAG, "addEnergyDrink: energyCount " + energyCount);
    }

    /**
        Getter and Setter
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

            switch (i){
                case 0:
                    return ClickerFragment.instantiate(getApplicationContext(), "com.jplsw.coffeeclicker.pages.ClickerFragment");
                case 1:
                    return StatsFragment.instantiate(getApplicationContext(), "com.jplsw.coffeeclicker.pages.StatsFragment");
                case 2:
                    return GraphFragment.instantiate(getApplicationContext(), "com.jplsw.coffeeclicker.pages.GraphFragment");
                default: return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
