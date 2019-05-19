package com.example.sabine.projetantibio2019.mesClasses;

import java.io.Serializable;

public class AntibioParKilo extends Antibiotique implements Serializable {
    private int doseKilo;
    public AntibioParKilo(String pLibelle,  String pUnite, Categorie pCategorie, int pDoseKilo)    {
        super(pLibelle, pUnite, pCategorie);
        this.doseKilo = pDoseKilo;
    }
    public int getDoseKilo()    {
        return this.doseKilo;
    }
}
