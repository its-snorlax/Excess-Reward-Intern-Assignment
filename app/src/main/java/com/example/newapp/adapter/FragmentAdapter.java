package com.example.newapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.newapp.fragments.ListFragment;
import com.example.newapp.fragments.NotificationFragment;
import com.example.newapp.fragments.StoreFragment;
import com.example.newapp.fragments.DashboardFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public FragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DashboardFragment();
            case 1:
                return new StoreFragment();
            case 2:
                return new NotificationFragment();
            case 3:
                return new ListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
