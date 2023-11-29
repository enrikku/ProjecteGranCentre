package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.gran_centre.Eventos.EventoAdapter;
import com.example.gran_centre.Eventos.clEventos;
import com.example.gran_centre.Hotel.HotelAdapter;
import com.example.gran_centre.Hotel.clHotel;

import java.util.ArrayList;

public class events extends AppCompatActivity {
    ArrayList<clEventos> listaEventos = new ArrayList<clEventos>();
    RecyclerView recyclerView;
    EventoAdapter eventoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        addEventos();
        initRecyclerView();
    }

    public void addEventos()
    {
        listaEventos.add(new clEventos("Concierto Buhos", "Madrid", "Concierto"));
        listaEventos.add(new clEventos("Painball", "Barcelona", "Entretenimiento"));
        listaEventos.add(new clEventos("Cine a la fresca", "Barcelona", "Entretenimiento"));
        listaEventos.add(new clEventos("Cena con vecinos", "Barcelona", "Cena"));
    }

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerView);
        eventoAdapter = new EventoAdapter(this, listaEventos);
        recyclerView.setAdapter(eventoAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}