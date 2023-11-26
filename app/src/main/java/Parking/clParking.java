
package Parking;

public class clParking {
    private String nom;
    private  String direcc;
    private int placesDisp;
    private int placesOcupades;
    private  String tel;

    private String pho;
    public clParking(String nombre, String direccion, String telefono,int pD,int pO,String photo){
        this.nom = nombre;
        this.direcc = direccion;
        this.tel = telefono;
        this.placesDisp = pD;
        this.placesOcupades=pO;
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

    public int getPlacesDisp(){
        return this.placesDisp;
    }

    public  int getPlacesOcupades(){return this.placesOcupades;}
    public String getPhoto(){
        return this.pho;
    }

}