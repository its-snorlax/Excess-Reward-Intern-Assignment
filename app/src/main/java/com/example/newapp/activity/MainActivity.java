package com.example.newapp.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.newapp.R;
import com.example.newapp.fragments.DashboardFragment;
import com.example.newapp.fragments.ListFragment;
import com.example.newapp.fragments.NotificationFragment;
import com.example.newapp.fragments.StoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Spinner spinner = findViewById(R.id.spinner_data);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.spinner_items,android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setSelection(0);
        spinner.setAdapter(spinnerAdapter);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view_main);
        frameLayout = findViewById(R.id.frame_layout);

        loadFragment(new DashboardFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_dashboard:
                        fragment = new DashboardFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_store:
                        fragment = new StoreFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_notification:
                        fragment = new NotificationFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_list:
                        fragment = new ListFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
