package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gran_centre.Hotel.HotelAdapter;
import com.example.gran_centre.Hotel.clHotel;

import java.util.ArrayList;
import java.util.Iterator;

public class HotelsActivity extends AppCompatActivity
{
    ArrayList<clHotel> listaHoteles = new ArrayList<clHotel>();
    RecyclerView recyclerView;
    Spinner spinner;
    HotelAdapter hotelAdapter;
    TextView tel;
    TextView web;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        ImageView arrowBack = findViewById(R.id.arrowBack);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addHotels();
        initRecyclerView();
        initSpinner();






        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Filtra los elementos del RecyclerView según el valor seleccionado en el Spinner
                String estrellaSeleccionada = parentView.getItemAtPosition(position).toString();
                if(!estrellaSeleccionada.equals("Sin filtros") ){
                    filtrarPorEstrella(estrellaSeleccionada);
                }else{
                    listaHoteles.clear();
                    addHotels();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Manejar el caso en el que no se ha seleccionado nada (opcional)
            }

            public void filtrarPorEstrella(String estrellaSeleccionada) {

                ArrayList<clHotel> hotelesFiltrados = new ArrayList<>();
                listaHoteles.clear();
                addHotels();



                for (clHotel hotel : listaHoteles) {
                    // Filtra los hoteles según el valor seleccionado en el Spinner
                    if (hotel.getVal().equals(estrellaSeleccionada)) {
                        hotelesFiltrados.add(hotel);
                    }
                }

                // Actualiza la lista de hoteles en el adaptador con los hoteles filtrados
                listaHoteles.clear();
                listaHoteles.addAll(hotelesFiltrados);
                hotelAdapter.notifyDataSetChanged();

            }
        });
    }

    public void addHotels()
    {
        listaHoteles.add(new clHotel("Hotel Gran Plaza", "Plaza Principal 123", "+34 111 222 333", "www.hotelgranplaza.com", "4", "https://as2.ftcdn.net/v2/jpg/00/09/21/15/1000_F_9211505_d4hxfNtPeTfgt7AeGmoO7u79P2hwxkoQ.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel del Valle", "Avenida del Valle 456", "+34 333 444 555", "www.granhoteldelvalle.com", "3", "https://example.com/hotel2.jpg"));
        listaHoteles.add(new clHotel("Hotel Elegante Granollers", "Calle Elegancia 789", "+34 666 777 888", "www.hotelelegantegranollers.com", "5", "https://example.com/hotel3.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel Montaña", "Carretera de Montaña 101", "+34 999 000 111", "www.granhotelmontana.com", "4", "https://example.com/hotel4.jpg"));
        listaHoteles.add(new clHotel("Hotel Moderno Granollers", "Calle Modernidad 202", "+34 123 987 654", "www.hotelmodernogranollers.com", "3", "https://example.com/hotel5.jpg"));
        listaHoteles.add(new clHotel("Hotel Sereno Granollers", "Calle Serenidad 303", "+34 111 222 333", "www.hotelserenogranollers.com", "4", "https://example.com/hotel6.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel Tranquilidad", "Avenida Tranquila 456", "+34 333 444 555", "www.granhoteltranquilidad.com", "5", "https://example.com/hotel7.jpg"));
        listaHoteles.add(new clHotel("Hotel Exclusivo Granollers", "Calle Exclusividad 789", "+34 666 777 888", "www.hotelexclusivogranollers.com", "3", "https://example.com/hotel8.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel Vista Montserrat", "Carretera Vista Montserrat 101", "+34 999 000 111", "www.hotelvistamontserrat.com", "4", "https://example.com/hotel9.jpg"));

    }
    private void initSpinner(){
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.estrella, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerView);
        hotelAdapter = new HotelAdapter(this, listaHoteles);
        recyclerView.setAdapter(hotelAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}