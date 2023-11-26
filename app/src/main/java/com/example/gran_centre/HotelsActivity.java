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
                    hotelAdapter.notifyDataSetChanged();
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
        listaHoteles.add(new clHotel("Hotel Gran Plaza", "Plaza Principal 123", "+34 111 222 333", "www.hotelgranplaza.com", "4", "https://s1.abcstatics.com/media/MM/2020/08/10/hoteles_espaa_lujo-U301387819834kHH--1234x900@abc.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel del Valle", "Avenida del Valle 456", "+34 333 444 555", "www.granhoteldelvalle.com", "3", "https://s1.abcstatics.com/media/MM/2020/08/05/non-set-mallorca-kA0D--1258x900@abc.jpg"));
        listaHoteles.add(new clHotel("Hotel Elegante Granollers", "Calle Elegancia 789", "+34 666 777 888", "www.hotelelegantegranollers.com", "5", "https://static.hosteltur.com/app/public/uploads/img/articles/2023/03/24/L_105222_hotel-kaizen-don-ramon-patio-r.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel Montaña", "Carretera de Montaña 101", "+34 999 000 111", "www.granhotelmontana.com", "4", "https://imagenes.elpais.com/resizer/7IPg9OaCbcfqwO349J8pkoAaZVA=/1200x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/PZHPU56HUHMDZPWGNYLY2ZHWLM.jpg"));
        listaHoteles.add(new clHotel("Hotel Moderno Granollers", "Calle Modernidad 202", "+34 123 987 654", "www.hotelmodernogranollers.com", "3", "https://phantom-elmundo.unidadeditorial.es/ab7462c469bca71f4efe4df26065a388/resize/600/f/webp/assets/multimedia/imagenes/2023/05/26/16850955381895.jpg"));
        listaHoteles.add(new clHotel("Hotel Sereno Granollers", "Calle Serenidad 303", "+34 111 222 333", "www.hotelserenogranollers.com", "4", "https://phantom-elmundo.unidadeditorial.es/e86aa29689b166016bd3291e51d082e1/resize/600/f/webp/assets/multimedia/imagenes/2023/05/26/16850955678723.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel Tranquilidad", "Avenida Tranquila 456", "+34 333 444 555", "www.granhoteltranquilidad.com", "5", "https://images.ecestaticos.com/VFbzEF_rJCfFuIrApYUw88wuV5w=/0x0:2000x1333/996x747/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F5f4%2Facf%2Fc73%2F5f4acfc737a4cab206514bf0d378f6e1.jpg"));
        listaHoteles.add(new clHotel("Hotel Exclusivo Granollers", "Calle Exclusividad 789", "+34 666 777 888", "www.hotelexclusivogranollers.com", "3", "https://static.hosteltur.com/app/public/uploads/img/articles/2023/06/11/L_214523_hotel-estimar-benicassim.jpg"));
        listaHoteles.add(new clHotel("Gran Hotel Vista Montserrat", "Carretera Vista Montserrat 101", "+34 999 000 111", "www.hotelvistamontserrat.com", "4", "https://www.construcia.com/wp-content/uploads/2022/12/Portada-Hotel-Apolo-1.png"));

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