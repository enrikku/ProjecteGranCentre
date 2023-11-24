package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;

public class RestaurantesActivity extends AppCompatActivity implements View.OnClickListener {
    GridLayout res1, res2;
    ImageView btPhoneRes1, btWebRes1, btMapsRes1;
    ImageView[] btRestaurants;
    TextView textRes1, textRes2;
    Spinner xspinner;
    ArrayAdapter<CharSequence> adapter; //Necessari per funcionament spinner.
    Intent intent;
    String[] tiposRestaurantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        //Agafar layout restaurants:
        res1 = findViewById(R.id.blocRes1);
        res2 = findViewById(R.id.blocRes2);

        //Codi funcionament spinner:
        xspinner = findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tiposRestaurantes,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        xspinner.setAdapter(adapter);

        spinnerListener();

        //Afegir text tipos restaurant:
        tiposRestaurantes = getResources().getStringArray(R.array.tiposRestaurantes);
        textRes1 = findViewById(R.id.tiposRes1);
        textRes1.setText(tiposRestaurantes[1]);

        textRes2 = findViewById(R.id.tiposRes2);
        textRes2.setText(tiposRestaurantes[2]);

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
                mostrarRestaurantesPorTipo(tiposRestaurantes[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });
    }

    private void mostrarRestaurantesPorTipo(String tipoSeleccionado) {
        if (tipoSeleccionado.equals(textRes1.getText().toString()) || tipoSeleccionado.equals("All"))
        {
            res1.setVisibility(View.VISIBLE);
        }
        else
        {
            if (!tipoSeleccionado.equals(textRes1.getText().toString()))
            {
                res1.setVisibility(View.INVISIBLE);
            }
        }

        if (tipoSeleccionado.equals(textRes2.getText().toString()) || tipoSeleccionado.equals("All"))
        {
            res2.setVisibility(View.VISIBLE);
        }
        else
        {
            if (!tipoSeleccionado.equals(textRes2.getText().toString()))
            {
                res2.setVisibility(View.INVISIBLE);
            }
        }

    }
}

