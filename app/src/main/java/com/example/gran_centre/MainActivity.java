package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ImageWriter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView edifici, restaurant, camara, peliculas, hotel, llibre;
    // Aixo es declarar
    ImageView[] img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dins del onCreate declarem new


        edifici = findViewById(R.id.edifici);
        restaurant = findViewById(R.id.restaurant);
        camara = findViewById(R.id.peliculas);
        peliculas = findViewById(R.id.temperatura);
        hotel = findViewById(R.id.hotel);
        llibre = findViewById(R.id.llibre);

        img = new ImageView[]{edifici, restaurant, camara, peliculas, hotel, llibre};

        for(ImageView element : img ){
            element.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.edifici){
            Toast.makeText(this, "Edifici", Toast.LENGTH_SHORT).show();
        }else if (view.getId() == R.id.restaurant){
            Intent intent = new Intent(this, RestaurantesActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.peliculas){
            Toast.makeText(this, "Peliculas", Toast.LENGTH_SHORT).show();

        }else if (view.getId() == R.id.temperatura){
            Toast.makeText(this, "Temperatura", Toast.LENGTH_SHORT).show();

        }else if (view.getId() == R.id.hotel){
            Intent intent = new Intent(this, HotelsActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.llibre){
            Toast.makeText(this, "Llibre", Toast.LENGTH_SHORT).show();
        }
    }
}