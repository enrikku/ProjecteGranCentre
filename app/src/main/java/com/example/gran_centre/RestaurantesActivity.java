package com.example.gran_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;

public class RestaurantesActivity extends AppCompatActivity implements View.OnClickListener {
    GridLayout res1, res2, res3, res4, res5;
    GridLayout[] blocRestaurants;
    ImageView imgRes1, imgRes2, imgRes3, imgRes4, imgRes5;
    ImageView btPhoneRes1, btWebRes1, btMapsRes1, btPhoneRes2, btWebRes2, btMapsRes2, btPhoneRes3, btWebRes3, btMapsRes3, btPhoneRes4, btWebRes4, btMapsRes4, btPhoneRes5, btWebRes5, btMapsRes5;
    ImageView[] btRestaurants;
    TextView textRes1, textRes2, textRes3, textRes4, textRes5;
    TextView[] textsRestaurants;
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
        res3 = findViewById(R.id.blocRes3);
        res4 = findViewById(R.id.blocRes4);
        res5 = findViewById(R.id.blocRes5);

        blocRestaurants = new GridLayout[]{res1, res2, res3, res4, res5};

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

        //Afegir img holder:
        imgRes1 = findViewById(R.id.imgRes1);
        imgRes2 = findViewById(R.id.imgRes2);
        imgRes3 = findViewById(R.id.imgRes3);
        imgRes4 = findViewById(R.id.imgRes4);
        imgRes5 = findViewById(R.id.imgRes5);

        Glide.with(this)
                .load("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/2a/d3/b6/sala.jpg?w=600&h=400&s=1")
                .error(R.drawable.ic_error_foreground) // Puedes establecer una imagen de error si la carga falla
                .into(imgRes1);

        Glide.with(this)
                .load("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/77/91/ca/el-rincon-de-nuestros.jpg?w=600&h=-1&s=1")
                .error(R.drawable.ic_error_foreground) // Puedes establecer una imagen de error si la carga falla
                .into(imgRes2);

        Glide.with(this)
                .load("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/7b/08/e1/can-forquilla.jpg?w=600&h=400&s=1")
                .error(R.drawable.ic_error_foreground) // Puedes establecer una imagen de error si la carga falla
                .into(imgRes3);

        Glide.with(this)
                .load("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/cb/4a/2e/vista-de-la-bodega.jpg?w=600&h=400&s=1")
                .error(R.drawable.ic_error_foreground) // Puedes establecer una imagen de error si la carga falla
                .into(imgRes4);

        Glide.with(this)
                .load("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/94/8f/c3/salonet-per-15-persones.jpg?w=600&h=-1&s=1")
                .error(R.drawable.ic_error_foreground) // Puedes establecer una imagen de error si la carga falla
                .into(imgRes5);

        //Afegir text tipos restaurant:
        tiposRestaurantes = getResources().getStringArray(R.array.tiposRestaurantes);
        textRes1 = findViewById(R.id.tiposRes1);
        textRes1.setText(tiposRestaurantes[1]);

        textRes2 = findViewById(R.id.tiposRes2);
        textRes2.setText(tiposRestaurantes[2]);

        textRes3 = findViewById(R.id.tiposRes3);
        textRes3.setText(tiposRestaurantes[3]);

        textRes4 = findViewById(R.id.tiposRes4);
        textRes4.setText(tiposRestaurantes[1]);

        textRes5 = findViewById(R.id.tiposRes5);
        textRes5.setText(tiposRestaurantes[2]);

        textsRestaurants = new TextView[]{textRes1, textRes2, textRes3, textRes4, textRes5};

        //Afegir funcionalitat als botons:
        btPhoneRes1 = findViewById(R.id.phoneRes1);
        btWebRes1 = findViewById(R.id.webRes1);
        btMapsRes1 = findViewById(R.id.mapsRes1);

        btPhoneRes2 = findViewById(R.id.phoneRes2);
        btWebRes2 = findViewById(R.id.webRes2);
        btMapsRes2 = findViewById(R.id.mapsRes2);

        btPhoneRes3 = findViewById(R.id.phoneRes3);
        btWebRes3 = findViewById(R.id.webRes3);
        btMapsRes3 = findViewById(R.id.mapsRes3);

        btPhoneRes4 = findViewById(R.id.phoneRes4);
        btWebRes4 = findViewById(R.id.webRes4);
        btMapsRes4 = findViewById(R.id.mapsRes4);

        btPhoneRes5 = findViewById(R.id.phoneRes5);
        btWebRes5  = findViewById(R.id.webRes5);
        btMapsRes5 = findViewById(R.id.mapsRes5);

        btRestaurants = new ImageView[]{btPhoneRes1, btWebRes1, btMapsRes1, btPhoneRes2, btWebRes2, btMapsRes2, btPhoneRes3, btWebRes3, btMapsRes3, btPhoneRes4, btWebRes4, btMapsRes4, btPhoneRes5, btWebRes5, btMapsRes5};

        for(ImageView restaurant : btRestaurants)
        {
            restaurant.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        //Botons restaurant 1:
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

        //Botons restaurant 2:
        if (v.getId() == R.id.phoneRes2) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("tel:665473838"));
            startActivity(intent);
        }

        if (v.getId() == R.id.webRes2) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://vinyam.es/"));
            startActivity(intent);
        }

        if (v.getId() == R.id.mapsRes2) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:41.6059493, 2.281714"));
            startActivity(intent);
        }

        //Botons restaurant 3:
        if (v.getId() == R.id.phoneRes3) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("tel:627548392"));
            startActivity(intent);
        }

        if (v.getId() == R.id.webRes3) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/CanForquilla/"));
            startActivity(intent);
        }

        if (v.getId() == R.id.mapsRes3) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:41.5752675, 2.2989764"));
            startActivity(intent);
        }

        //Botons restaurant 4:
        if (v.getId() == R.id.phoneRes4) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("tel:698324472"));
            startActivity(intent);
        }

        if (v.getId() == R.id.webRes4) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.robertdenola.cat/cas/index.htm"));
            startActivity(intent);
        }

        if (v.getId() == R.id.mapsRes4) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:41.6389711, 2.158907"));
            startActivity(intent);
        }

        //Botons restaurant 5:
        if (v.getId() == R.id.phoneRes5) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("tel:692184620"));
            startActivity(intent);
        }

        if (v.getId() == R.id.webRes5) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lagamba.com/"));
            startActivity(intent);
        }

        if (v.getId() == R.id.mapsRes5) {
            intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:41.6086634, 2.2852621"));
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
        for (int i = 0; i < textsRestaurants.length; i++)
        {
            if (tipoSeleccionado.equals(textsRestaurants[i].getText().toString()) || tipoSeleccionado.equals("All"))
            {
                blocRestaurants[i].setVisibility(View.VISIBLE);

                restablirGridLayout(blocRestaurants[i]);
                modificarMarginTop(blocRestaurants[i], 30);
            }
            else
            {
                if (!tipoSeleccionado.equals(textsRestaurants[i].getText().toString()))
                {
                    blocRestaurants[i].setVisibility(View.INVISIBLE);

                    eliminarGridLayoutDimens(blocRestaurants[i]);
                    modificarMarginTop(blocRestaurants[i], 0);
                }
            }
        }
    }

    private void eliminarGridLayoutDimens(GridLayout blocRestaurants) {
        ViewGroup.LayoutParams params = blocRestaurants.getLayoutParams();
        params.width = 0;
        params.height = 0;
        blocRestaurants.setLayoutParams(params);
    }

    private void restablirGridLayout(GridLayout blocRestaurants) {
        ViewGroup.LayoutParams params = blocRestaurants.getLayoutParams();
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT; // o el valor original
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT; // o el valor original
        blocRestaurants.setLayoutParams(params);
    }

    private void modificarMarginTop(GridLayout blocRestaurants, int marginTop) {
        // Obtén los parámetros del diseño del GridLayout
        GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) blocRestaurants.getLayoutParams();
        // Establece el margen superior a 0
        layoutParams.topMargin = marginTop;
        // Aplica los nuevos parámetros al GridLayout
        blocRestaurants.setLayoutParams(layoutParams);
        blocRestaurants.requestLayout(); // Solicita un nuevo diseño para aplicar los cambios
    }
}