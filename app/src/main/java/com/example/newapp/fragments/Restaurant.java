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
import com.example.newapp.R;
import com.example.newapp.adapter.RestaurantAdapter;
import com.example.newapp.model.RestaurantDetail;

import java.util.ArrayList;

public class Restaurant extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ArrayList<RestaurantDetail> restaurantDetails = new ArrayList<>();
        restaurantDetails.add(new RestaurantDetail(R.drawable.restaurant_green_icon_27, "ABKD0",5,true,0.5,234));
        restaurantDetails.add(new RestaurantDetail(R.drawable.restaurant_green_icon_27, "ABKD0",4,true,0.2,234));
        restaurantDetails.add(new RestaurantDetail(R.drawable.restaurant_green_icon_27, "ABKD0",5,false,1.5,234));
        restaurantDetails.add(new RestaurantDetail(R.drawable.restaurant_green_icon_27, "ABKD0",3,false,2.5,234));

        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantDetails, getContext());
        RecyclerView recylerView = rootView.findViewById(R.id.recycle_view);
        recylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recylerView.setAdapter(restaurantAdapter);
        return rootView;
    }
}
