package com.example.gran_centre.Eventos;

public class clEventos {

    private String nom;
    private  String ciudad;
    private String categoria;

    public clEventos(String nombre, String ciudad, String categoria){
        this.nom = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
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
}
