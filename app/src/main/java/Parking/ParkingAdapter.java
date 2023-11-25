package Parking;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gran_centre.DetailsParkingActivity;
import com.example.gran_centre.R;

import java.util.ArrayList;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ViewHolder> {
    private Context context;
    private ArrayList<clParking> parkingList;

    // Constructor
    public ParkingAdapter(Context context, ArrayList<clParking> parkingList) {
        this.context = context;
        this.parkingList = parkingList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.parking_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        clParking parking = parkingList.get(position);

        // Set data to views
        Uri imageUri = Uri.parse(parking.getPhoto());
        // Cargar la imagen usando Glide
        Glide.with(context).load(parking.getPhoto()).into(holder.imageViewParking);
        holder.textViewParkingName.setText(parking.getNom());
        holder.textViewOccupied.setText("Plazas ocupadas: " + parking.getPlacesOcupades());
        holder.textViewAvailable.setText("Plazas disponibles: " + parking.getPlacesDisp());

        // Agrega un OnClickListener al botón de detalles (puedes personalizar la acción según tus necesidades)
        holder.buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsParkingActivity.class);
                intent.putExtra("nombre", parking.getNom());
                intent.putExtra("direccion", parking.getDirecc());
                intent.putExtra("tel", parking.getTel());
                intent.putExtra("disp", parking.getPlacesDisp());
                intent.putExtra("ocup", parking.getPlacesOcupades());

                // Agrega otros detalles que desees pasar
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parkingList.size();
    }

    // Clase ViewHolder para inicializar las vistas como TextView, ImageView y Button
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewParkingName;
        private TextView textViewOccupied;
        private TextView textViewAvailable;
        private ImageView imageViewParking;
        private Button buttonDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializar vistas
            textViewParkingName = itemView.findViewById(R.id.textViewParkingName);
            textViewOccupied = itemView.findViewById(R.id.textViewOccupied);
            textViewAvailable = itemView.findViewById(R.id.textViewAvailable);
            imageViewParking = itemView.findViewById(R.id.imageViewParking);
            buttonDetails = itemView.findViewById(R.id.buttonDetails);
        }
    }
}
