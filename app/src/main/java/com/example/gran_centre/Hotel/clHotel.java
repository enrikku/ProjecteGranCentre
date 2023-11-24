package com.example.gran_centre.Hotel;

import android.net.Uri;

import java.net.URL;

public class clHotel {
    private String nom;
    private  String direcc;
    private  String tel;
    private String www;
    private String val;
    private String pho;
    public clHotel(String nombre, String direccion, String telefono, String web, String valoracio, String photo){
        this.nom = nombre;
        this.direcc = direccion;
        this.tel = telefono;
        this.www = web;
        this.val = valoracio;
        this.pho = photo;
    }

    public String getNom(){
        return this.nom;
    }

    public String getDirecc(){
        return this.direcc;
    }
    public String getTel(){
        return this.tel;
    }

    public String getWww(){
        return this.www;
    }

    public String getVal(){
        return this.val;
    }
    public String getPhoto(){
        return this.pho;
    }


}
