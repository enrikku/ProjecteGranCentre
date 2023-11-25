package com.example.gran_centre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gran_centre.R;

import java.util.ArrayList;

import Parking.ParkingAdapter;
import Parking.clParking;

public class ParkingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ParkingAdapter parkingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        ImageView arrowBack = findViewById(R.id.backArrow);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParkingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Crea una lista de parqueos (puedes agregar tus propios datos aquí)
        ArrayList<clParking> parkingList = new ArrayList<>();
        parkingList.add(new clParking("Parking A", "Dirección A", "+34 111 222 333", 20, 5, "URL_IMAGEN_A"));
        parkingList.add(new clParking("Parking B", "Dirección B", "+34 444 555 666", 30, 10, "URL_IMAGEN_B"));
        // Añade más parqueos si es necesario

        // Inicializa el RecyclerView y su adaptador
        recyclerView = findViewById(R.id.recyclerViewParking);
        parkingAdapter = new ParkingAdapter(this, parkingList);
        recyclerView.setAdapter(parkingAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
