package com.example.gran_centre.Eventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gran_centre.R;

import java.util.ArrayList;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder>{
    private Context context;
    private ArrayList<clEventos> eventos;

    public EventoAdapter(Context context, ArrayList<clEventos> eventos) {
        this.context = context;
        this.eventos = eventos;
    }

    @NonNull
    @Override
    public EventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.evento_card_view, parent, false);
        return new EventoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder holder, int position) {
        clEventos evento = eventos.get(position);

        // Set data to views

        Toast.makeText(context, evento.getImg(), Toast.LENGTH_SHORT).show();

        Glide.with(context)
                .load(evento.getImg())
                .error(R.drawable.ic_error_foreground)
                .into(holder.imageViewCompany);

            holder.textViewEventoNombre.setText(evento.getNom());
            holder.textViewEventoCiudad.setText(evento.getCiudad());
            holder.textViewEventoCategoria.setText(evento.getCategoria());

    }


    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewEventoNombre;
        private TextView textViewEventoCiudad;
        private TextView textViewEventoCategoria;
        private ImageView imageViewCompany;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            textViewEventoNombre = itemView.findViewById(R.id.textViewEventoNombre);
            textViewEventoCiudad = itemView.findViewById(R.id.textViewEventoCiudad);
            textViewEventoCategoria = itemView.findViewById(R.id.textViewEventoCategoria);
            imageViewCompany = itemView.findViewById(R.id.imageViewCompany);
        }

    }
}
