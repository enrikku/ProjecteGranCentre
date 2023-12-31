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
        // En tu actividad o fragmento
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Crea e instancia tu adaptador
        EventoAdapter eventoAdapter = new EventoAdapter(this, listaEventos);

        // Configura el RecyclerView con el adaptador
        recyclerView.setAdapter(eventoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addEventos();

        initRecyclerView();
    }

    public void addEventos()
    {
        listaEventos.add(new clEventos("Concierto Buhos", "Madrid", "Concierto", "https://media.timeout.com/images/106059079/image.jpg"));
        listaEventos.add(new clEventos("Painball", "Barcelona", "Entretenimiento", "https://png.pngtree.com/png-vector/20201224/ourmid/pngtree-culture-and-entertainment-internet-live-broadcast-promotion-business-marketing-2-5d-png-image_2620020.jpg"));
        listaEventos.add(new clEventos("Cine a la fresca", "Barcelona", "Entretenimiento", "https://png.pngtree.com/png-vector/20201224/ourmid/pngtree-culture-and-entertainment-internet-live-broadcast-promotion-business-marketing-2-5d-png-image_2620020.jpg"));
        listaEventos.add(new clEventos("Cena con vecinos", "Barcelona", "Cena", "https://upload.wikimedia.org/wikipedia/commons/1/1d/Cena_Navide%C3%B1a.JPG"));
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