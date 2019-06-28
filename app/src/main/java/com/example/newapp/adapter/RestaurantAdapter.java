package com.example.newapp.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.newapp.R;
import com.example.newapp.model.RestaurantDetail;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private ArrayList<RestaurantDetail> restaurantDetails;
    private Context context;

    public RestaurantAdapter(ArrayList<RestaurantDetail> restaurantDetails, Context context) {
        this.restaurantDetails = restaurantDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item_restaurant, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RestaurantDetail currentListItem = restaurantDetails.get(position);
        holder.imageView.setImageResource(currentListItem.getImage());
        holder.name.setText(currentListItem.getName());
        for (int i=0 ; i<currentListItem.getRating();i++){
            holder.ratings[i].setImageResource(R.drawable.ic_select_rating);
        }
        if(currentListItem.isIsopen()){
            holder.isOpenView.setText("Open Now");
        }else{
            holder.isOpenView.setTextColor(context.getResources().getColor(R.color.red));
            holder.isOpenView.setText("Closed Now");
        }
        holder.distanceFromYouView.setText(currentListItem.getDistanceFromYou() + " from you");
        holder.priceView.setText(currentListItem.getPrice() + " $");
    }

    @Override
    public int getItemCount() {
        return restaurantDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        private ImageView r1,r2,r3,r4,r5;
        private ImageView[] ratings;
        private TextView isOpenView;
        private TextView distanceFromYouView;
        private TextView priceView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);

            name = itemView.findViewById(R.id.name);

            r1 = itemView.findViewById(R.id.rating1);
            r2 = itemView.findViewById(R.id.rating2);
            r3 = itemView.findViewById(R.id.rating3);
            r4 = itemView.findViewById(R.id.rating4);
            r5 = itemView.findViewById(R.id.rating5);

            ratings = new ImageView[]{r1, r2, r3, r4, r5};
            isOpenView = itemView.findViewById(R.id.is_open);
            distanceFromYouView = itemView.findViewById(R.id.distance_from_you);
            priceView = itemView.findViewById(R.id.price);
        }
    }
}
