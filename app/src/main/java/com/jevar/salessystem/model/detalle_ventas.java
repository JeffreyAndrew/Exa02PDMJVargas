package com.jevar.salessystem.model;

public class detalle_ventas {

    private String nom_prod;


    public detalle_ventas() {
    }

    public detalle_ventas(String nom_prodn) {
        this.nom_prod = nom_prod;

    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }


}
