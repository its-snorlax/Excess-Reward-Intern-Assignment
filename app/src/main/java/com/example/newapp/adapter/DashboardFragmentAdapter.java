package com.example.newapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.newapp.fragments.Bars;
import com.example.newapp.fragments.Cafe;
import com.example.newapp.fragments.CoffeeAndTea;
import com.example.newapp.fragments.Restaurant;

public class DashboardFragmentAdapter extends FragmentPagerAdapter {
    private int tabCount;

    public DashboardFragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Restaurant();
            case 1:
                return new Cafe();
            case 2:
                return new Bars();
            case 3:
                return new CoffeeAndTea();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
