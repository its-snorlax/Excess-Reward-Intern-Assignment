package com.example.newapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.newapp.R;
import com.example.newapp.adapter.DashboardFragmentAdapter;
import com.example.newapp.adapter.RestaurantAdapter;
import com.example.newapp.model.RestaurantDetail;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DashboardFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        tabLayout = rootView.findViewById(R.id.tab_layout_dashboard);
        viewPager = rootView.findViewById(R.id.viewpager_dashboard);

        DashboardFragmentAdapter dashboardFragmentAdapter =
                new DashboardFragmentAdapter(getChildFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(dashboardFragmentAdapter);
        tabLayout.addOnTabSelectedListener(this);

        return rootView;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
