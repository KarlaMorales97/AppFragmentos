package com.example.rafaj.fragmentapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Karla on 14/04/2018.
 */

public class Comidas implements Serializable{
    String Nombre_Comida;
    String Calorias;
    String Colesterol;
    String imagen;


    public Comidas(String nombre_Comida, String calorias, String colesterol, String imagen) {
        Nombre_Comida = nombre_Comida;
        Calorias = calorias;
        Colesterol = colesterol;
        this.imagen = imagen;
    }


    public String getNombre_Comida() {
        return Nombre_Comida;
    }

    public void setNombre_Comida(String nombre_Comida) {
        Nombre_Comida = nombre_Comida;
    }

    public String getCalorias() {
        return Calorias;
    }

    public void setCalorias(String calorias) {
        Calorias = calorias;
    }

    public String getColesterol() {
        return Colesterol;
    }

    public void setColesterol(String colesterol) {
        this.Colesterol = colesterol;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



}
