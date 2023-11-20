package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;

public class RestaurantesActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btPhoneRes1, btWebRes1, btMapsRes1;
    TextView textRes1;
    Spinner xspinner;
    ArrayAdapter<CharSequence> adapter; //Necessari per funcionament spinner.
    Intent intent;
    ImageView[] btRestaurants;
    String[] tiposRestaurantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        //Codi funcionament spinner:
        xspinner = findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tiposRestaurantes,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        xspinner.setAdapter(adapter);



        //Afegir text tipos restaurant:
        tiposRestaurantes = getResources().getStringArray(R.array.tiposRestaurantes);
        textRes1 = findViewById(R.id.tiposRes1);
        textRes1.setText(tiposRestaurantes[0]);

        //Afegir funcionalitat als botons:
        btPhoneRes1 = findViewById(R.id.phoneRes1);
        btWebRes1 = findViewById(R.id.webRes1);
        btMapsRes1 = findViewById(R.id.mapsRes1);

        btRestaurants = new ImageView[]{btPhoneRes1, btWebRes1, btMapsRes1};

        for(ImageView restaurant : btRestaurants)
        {
            restaurant.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.phoneRes1) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("tel:648384393"));
            startActivity(intent);
        }

        if (v.getId() == R.id.webRes1) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/shaporem_restaurant/"));
            startActivity(intent);
        }

        if (v.getId() == R.id.mapsRes1) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:41.673125, 2.3960901"));
            startActivity(intent);
        }
    }

    private void spinnerListener() {
        xspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //mostrarRestaurantesPorTipo(tiposRestaurantes[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });
    }

    //private void mostrarRestaurantesPorTipo(String tipoSeleccionado) {}

}

