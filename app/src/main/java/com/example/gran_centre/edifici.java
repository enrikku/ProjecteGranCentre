package com.example.gran_centre;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class edifici extends AppCompatActivity implements View.OnClickListener {

    Spinner spiner;
    TextView nombre1, nombre2, nombre3, direccion1, direccion2, direccion3, telefono1, telefono2, telefono3, web1, web2, web3;
    TextView[] nombres;
    TextView[] direcciones;
    TextView[] telefonos;
    TextView[] webs;

    ImageView img1, img2, img3;
    clEmpresa[] empresas = new clEmpresa[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edifici);
        spiner = findViewById(R.id.spinner);

        nombre1 = findViewById(R.id.nombre1);
        nombre2 = findViewById(R.id.nombre2);
        nombre3 = findViewById(R.id.nombre3);
        direccion1 = findViewById(R.id.direccion1);
        direccion2 = findViewById(R.id.direccion2);
        direccion3 = findViewById(R.id.direccion3);
        telefono1 = findViewById(R.id.telefono1);
        telefono2 = findViewById(R.id.telefono2);
        telefono3 = findViewById(R.id.telefono3);
        web1 = findViewById(R.id.web1);
        web2 = findViewById(R.id.web2);
        web3 = findViewById(R.id.web3);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        nombres = new TextView[]{nombre1, nombre2, nombre3};
        direcciones = new TextView[]{direccion1, direccion2, direccion3};
        telefonos = new TextView[]{telefono1, telefono2, telefono3};
        webs = new TextView[]{web1, web2, web3};

        empresas[0] = new clEmpresa("Nova Perruquers", "Carrer d'Agustí Viñamata, 43, 08401 Granollers, Barcelona", 123456789, "", "Perruqueria");
        empresas[1] = new clEmpresa("Peluqueria Manuel Serrano", "Plaça Josep Maluquer i Salvador, 5, 08401 Granollers, Barcelona", 987654321, "www.empresa2.com", "Perruqueria");
        empresas[2] = new clEmpresa("Carol Bruguera", "Carrer Miquel Ricomà, 36, 08400 Granollers, Barcelona", 555555555, "", "Perruqueria");

        empresas[3] = new clEmpresa("AMS Granollers", "Carrer de Pinós, 15, 08402 Granollers, Barcelona", 333333333, "www.empresa4.com", "Taller");
        empresas[4] = new clEmpresa("Rodi Motor Services", "Avinguda d'Europa, 4, 08401 Granollers, Barcelona", 999999999, "www.empresa5.com", "Taller");
        empresas[5] = new clEmpresa("Midas", "Carrer de Francesc Macià i Llussà, 156, 08401 Granollers, Barcelona", 111111111, "www.empresa6.com", "Taller");

        empresas[6] = new clEmpresa("Joan Sitjes Granollers", "Plaça de la Porxada, 25, 08401 Granollers, Barcelona", 777777777, "www.empresa7.com", "Botiga");
        empresas[7] = new clEmpresa("Pull and Bear", "D'Anselm Clave, 57, 08402 Granollers, Barcelona", 444444444, "www.empresa8.com", "Botiga");
        empresas[8] = new clEmpresa("Barbany Granollers", "Carrer Anselm Clavé, 44, 08401 Granollers, Barcelona", 666666666, "www.empresa9.com", "Botiga");



        String [] opciones = {"Perruqueria", "Taller", "Botiga"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);

        spiner.setAdapter(adapter);

        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Aqui obtego el array con las empresas y sus valores segun el sector
                clEmpresa[] array = obtenerEmpresasSegunSector(parent.getItemAtPosition(position).toString());

                nombre1.setText(array[0].getNombre());
                direccion1.setText(array[0].getDireccion());
                telefono1.setText(String.valueOf(array[0].getTelefono()));
                if(array[0].getWeb() == ""){
                    web1.setText("Web no disponible");
                }else{
                    web1.setText(array[0].getWeb());
                }

                String nombreImg = array[0].getNombre().trim().replace(" ", "").toLowerCase();
                int resourceId = getResources().getIdentifier(nombreImg, "drawable", getPackageName());
                img1.setBackgroundResource(resourceId);


                nombre2.setText(array[1].getNombre());
                direccion2.setText(array[1].getDireccion());
                telefono2.setText(String.valueOf(array[1].getTelefono()));
                if(array[1].getWeb().equals("")){
                    web2.setText("Web no disponible");
                }else{
                    web2.setText(array[1].getWeb());
                }

                nombreImg = array[1].getNombre().trim().replace(" ", "").toLowerCase();
                resourceId = getResources().getIdentifier(nombreImg, "drawable", getPackageName());
                img2.setBackgroundResource(resourceId);

                nombre3.setText(array[2].getNombre());
                direccion3.setText(array[2].getDireccion());
                telefono3.setText(String.valueOf(array[2].getTelefono()));
                if(array[2].getWeb().equals("")){
                    web3.setText("Web no disponible");
                }else{
                    web3.setText(array[2].getWeb());
                }

                nombreImg = array[2].getNombre().trim().replace(" ", "").toLowerCase();
                resourceId = getResources().getIdentifier(nombreImg, "drawable", getPackageName());
                img3.setBackgroundResource(resourceId);
                // Toast.makeText(getApplication(), "Has seleccionado: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        for(TextView item : telefonos){
            item.setTag("Telefono");
            item.setOnClickListener(this);
        }

        for(TextView item : webs){
            item.setTag("Web");

            Toast.makeText(this, item.getText().toString(), Toast.LENGTH_SHORT).show();

            if(item.getText() == "Web no disponible"){
                item.setTextColor(Color.RED);
            }else{
                item.setOnClickListener(this);
            }
        }

        for(TextView item : direcciones){
            item.setTag("Direccion");
            item.setOnClickListener(this);
        }
    }



    public clEmpresa[] obtenerEmpresasSegunSector(String sector) {
        ArrayList<clEmpresa> miLista = new ArrayList<>();

        for (clEmpresa element : empresas) {
            if (element.getSector().equals(sector)) {
                miLista.add(element);
            }
        }

        // Convertir ArrayList a array
        clEmpresa[] miArray = miLista.toArray(new clEmpresa[0]);

        return miArray;
    }

    @Override
    public void onClick(View v) {
        switch (((TextView) v).getTag().toString()) {
            case "Telefono":
                String tlf = ((TextView) v).getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tlf, null));
                startActivity(intent);
                break;
            case "Web":
                String pagina = "http://" + ((TextView) v).getText().toString();
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(pagina));
                startActivity(intent2);
                break;
            case "Direccion":
                String direccio = ((TextView) v).getText().toString();
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + Uri.encode(direccio)));
                startActivity(intent3);
        }
    }
}