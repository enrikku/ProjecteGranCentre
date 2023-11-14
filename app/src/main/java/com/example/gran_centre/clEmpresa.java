package com.example.gran_centre;

public class clEmpresa {
    // Define variables
    private String nombre;
    private String direccion;
    private int telefono;
    private String web;
    private String sector;  // Nueva propiedad para el sector de la empresa

    // Define constructor
    public clEmpresa(String nombre, String direccion, int telefono, String web, String sector) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.web = web;
        this.sector = sector;
    }
    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
