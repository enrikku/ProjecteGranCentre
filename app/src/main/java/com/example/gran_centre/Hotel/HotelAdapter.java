package com.example.gran_centre.Hotel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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

        Uri imageUri = Uri.parse(hotel.getPhoto());
        Glide.with(context)
                .load("https://raulperez.tieneblog.net/wp-content/uploads/2015/09/tux-transparente.png")
                .error(R.drawable.ic_error_foreground)  // Error drawable
                .into(holder.imageViewCompany);
        holder.textViewCompanyName.setText(hotel.getNom());
        holder.textViewCompanyAddress.setText(hotel.getDirecc());
        holder.textViewCompanyPhone.setText(hotel.getTel());
        holder.textViewCompanyWeb.setText(hotel.getWww());
        holder.ratingBarCompany.setRating(Float.parseFloat(hotel.getVal()));

        holder.textViewCompanyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción a realizar cuando se hace clic en el número de teléfono
                String phoneNumber = hotel.getTel(); // Obtener el número de teléfono del hotel
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null));
                context.startActivity(dialIntent);
            }
        });

        holder.textViewCompanyWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción a realizar cuando se hace clic en el sitio web
                String pagina = "http://" + ((TextView) v).getText().toString();
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(pagina));
                context.startActivity(intent2);
            }
        });
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
