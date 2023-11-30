package com.example.gran_centre.Eventos;

public class clEventos {

    private String nom;
    private  String ciudad;
    private String categoria;

    private String img;

    public clEventos(String nombre, String ciudad, String categoria, String img){
        this.nom = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.img = img;
    }

    public String getNom(){
        return this.nom;
    }

    public String getCiudad(){
        return this.ciudad;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public String getImg(){
        return this.img;
    }
}
