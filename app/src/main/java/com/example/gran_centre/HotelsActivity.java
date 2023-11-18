package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        addHotels();
        initRecyclerView();
        initSpinner();




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Filtra los elementos del RecyclerView según el valor seleccionado en el Spinner
                String estrellaSeleccionada = parentView.getItemAtPosition(position).toString();
                filtrarPorEstrella(estrellaSeleccionada);
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
        listaHoteles.add(new clHotel("Hotel 1", "Dirección 1", "Teléfono 1", "www.hotel1.com", "5"));
        listaHoteles.add(new clHotel("Hotel 2", "Dirección 2", "Teléfono 2", "www.hotel2.com", "4"));
        listaHoteles.add(new clHotel("Hotel 3", "Dirección 3", "Teléfono 3", "www.hotel3.com", "3"));

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