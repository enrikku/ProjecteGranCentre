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
        parkingList.add(new clParking("Aparcament de granollers", "Camí Ramon Llull, 32, 08401 Granollers, Barcelona", "+34 111 222 333", 20, 5, "https://rafolsraventos.com/wp-content/uploads/2019/03/Parking-Aragon.jpg"));
        parkingList.add(new clParking("Aparcamiento Can Comas", "Carrer de Sant Jaume, 66, 08401 Granollers, Barcelona", "+34 937324677", 30, 10, "https://circontrol.com/wp-content/uploads/2023/10/180125-Circontrol-BAIXA-80-1.jpg"));
        parkingList.add(new clParking("Parking Hospital de granollers", "Carrer de Francesc Ribas, 08402 Granollers, Barcelona", "+34 903924487", 300, 1, "https://parkingdelaeropuerto.com/wp-content/uploads/2021/06/Parking-del-aeropuerto-instalaciones-madrid.jpg"));
        parkingList.add(new clParking("Parking Sant Carles", "C/ de Pompeu Fabra, 6, 08401 Granollers, Barcelona", "+34 935329687", 40, 20, "https://www.economiadigital.es/wp-content/uploads/2022/12/parking-lot-g009dfb410_1920-1000x665.jpg"));
        // Añade más parqueos si es necesario

        // Inicializa el RecyclerView y su adaptador
        recyclerView = findViewById(R.id.recyclerViewParking);
        parkingAdapter = new ParkingAdapter(this, parkingList);
        recyclerView.setAdapter(parkingAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
