package com.example.gran_centre.Hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gran_centre.R;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private Context context;
    private ArrayList<clHotel> hotels;

    // Constructor
    public HotelAdapter(Context context, ArrayList<clHotel> hotels) {
        this.context = context;
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotel_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        clHotel hotel = hotels.get(position);

        // Set data to views
        holder.textViewCompanyName.setText(hotel.getNom());
        holder.textViewCompanyAddress.setText(hotel.getDirecc());
        holder.textViewCompanyPhone.setText(hotel.getTel());
        holder.textViewCompanyWeb.setText(hotel.getWww());
        holder.ratingBarCompany.setRating(Float.parseFloat(hotel.getVal()));
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    // View holder class for initializing views such as TextView and ImageView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCompanyName;
        private TextView textViewCompanyAddress;
        private TextView textViewCompanyPhone;
        private TextView textViewCompanyWeb;
        private ImageView imageViewCompany;
        private RatingBar ratingBarCompany;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            textViewCompanyName = itemView.findViewById(R.id.textViewCompanyName);
            textViewCompanyAddress = itemView.findViewById(R.id.textViewCompanyAddress);
            textViewCompanyPhone = itemView.findViewById(R.id.textViewCompanyPhone);
            textViewCompanyWeb = itemView.findViewById(R.id.textViewCompanyWeb);
            imageViewCompany = itemView.findViewById(R.id.imageViewCompany);
            ratingBarCompany = itemView.findViewById(R.id.ratingBarCompany);
        }
    }
}
