package com.example.sabine.projetantibio2019.mesClasses;

import java.io.Serializable;

public class Categorie implements Serializable {
    private String libelle;
    public Categorie(String pLibelle) {
        this.libelle = pLibelle;
    }
    public String getLibelle()  {
        return this.libelle;
    }
    public boolean equals(Object o){ // pour utiliser indexOf ou contains
        String libelle =((Categorie) o).getLibelle();
        return (this.libelle.equals(libelle));
    }
}
