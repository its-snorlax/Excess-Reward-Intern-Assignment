package com.example.newapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.newapp.R;
import com.example.newapp.adapter.DashboardFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class DashboardFragment extends Fragment {

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


//        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(dashboardFragmentAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        return rootView;
    }

}
