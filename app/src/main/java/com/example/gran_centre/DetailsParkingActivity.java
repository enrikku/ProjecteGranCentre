package com.example.gran_centre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsParkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_parking);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String direccion = extras.getString("direccion");
            String tel = extras.getString("tel");
            int disp = extras.getInt("disp");
            int ocup = extras.getInt("ocup");

            // Actualizar los TextViews con la información
            TextView nameTextView = findViewById(R.id.textViewName);
            TextView addressTextView = findViewById(R.id.textViewAddress);
            TextView telTextView = findViewById(R.id.textViewTel);
            TextView dispTextView = findViewById(R.id.textViewDisp);
            TextView ocupTextView = findViewById(R.id.textViewOcup);
            ImageView arrowBack = findViewById(R.id.backArrow);

            nameTextView.setText(nombre);
            addressTextView.setText(direccion);
            telTextView.setText(tel);
            dispTextView.setText("Plazas Disponibles: " + disp);
            ocupTextView.setText("Plazas Ocupadas: " + ocup);

            // Agregar OnClickListener para el botón "Abrir Ubicación"
            Button btnOpenLocation = findViewById(R.id.BtnLocation);

            arrowBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DetailsParkingActivity.this,ParkingActivity.class);
                    startActivity(intent);
                }
            });
            btnOpenLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica para abrir la ubicación
                    abrirUbicacion();
                }
            });

            // Agregar OnClickListener para el botón "Llamar"
            Button btnMakeCall = findViewById(R.id.BtnCall);
            btnMakeCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica para realizar la llamada
                    realizarLlamada(tel);
                }
            });
        }
    }

    private void abrirUbicacion() {
        String direccionEstacionamiento = "Dirección del estacionamiento"; // Reemplaza con la dirección real del estacionamiento
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(direccionEstacionamiento));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps"); // Indica que quieres usar Google Maps
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Si Google Maps no está instalado, puedes manejarlo de acuerdo a tus necesidades
            // Por ejemplo, puedes abrir el navegador web con Google Maps en su versión web.
            abrirGoogleMapsEnNavegadorWeb();
        }
    }

    private void abrirGoogleMapsEnNavegadorWeb() {
        String direccionEstacionamiento = "Dirección del estacionamiento"; // Reemplaza con la dirección real del estacionamiento
        Uri webIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(direccionEstacionamiento));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webIntentUri);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        } else {
            // Manejar el caso en el que no haya una aplicación para manejar la acción
            // Puedes mostrar un mensaje al usuario indicando que no hay aplicaciones disponibles para abrir Google Maps.
        }
    }

    private void realizarLlamada(String numeroTelefono) {
        // Lógica para realizar la llamada
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", numeroTelefono, null));
        startActivity(intent);
    }
}
