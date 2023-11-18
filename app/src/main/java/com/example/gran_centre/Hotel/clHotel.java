package com.example.gran_centre.Hotel;

public class clHotel {
    private String nom;
    private  String direcc;
    private  String tel;
    private String www;
    private String val;
    public clHotel(String nombre, String direccion, String telefono, String web, String valoracio){
        this.nom = nombre;
        this.direcc = direccion;
        this.tel = telefono;
        this.www = web;
        this.val = valoracio;
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


}
