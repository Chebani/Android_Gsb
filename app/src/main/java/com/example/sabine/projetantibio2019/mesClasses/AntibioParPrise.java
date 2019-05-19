package com.example.sabine.projetantibio2019.mesClasses;

import java.io.Serializable;

public class AntibioParPrise extends Antibiotique implements Serializable {
    private int dosePrise;
    private int nombreParJour;
    public AntibioParPrise(String pLibelle,  String pUnite, Categorie pCategorie, int pDosePrise,int pNombre)    {
        super(pLibelle, pUnite, pCategorie);
        this.dosePrise = pDosePrise;
        this.nombreParJour = pNombre;
    }
    public int getDosePrise()    {
        return this.dosePrise;
    }
    public int getNombre()    {
        return this.nombreParJour;
    }
}
