package com.example.sabine.projetantibio2019.mesClasses;

import java.io.Serializable;

public abstract class Antibiotique implements Serializable {
    private String libelle;
    private String unite;
    private Categorie laCategorie;
    public Antibiotique(String pLibelle, String pUnite,Categorie pCategorie)    {
        this.libelle = pLibelle;
        this.unite = pUnite;
        this.laCategorie = pCategorie;
    }
    public String getLibelle()    {
        return this.libelle;
    }
    public String getUnite()    {
        return this.unite;
    }
    public Categorie getCategorie()    {
        return this.laCategorie;
    }
}
