package com.example.sabine.projetantibio2019.mesClasses;

import java.util.ArrayList;
import java.util.List;

public class DataAntibio {
    static private List<Antibiotique> lesAntibiotiques;
    static private List<Antibiotique> lesAntibiotiquesUneCateg;
    static private List<Categorie> lesCategories;

    static public void initialiser()    {
        DataAntibio.lesCategories = new ArrayList<Categorie>();
        Categorie uneCategorie1 = new Categorie("Aminoglycosides");
        DataAntibio.lesCategories.add(uneCategorie1);
        Categorie uneCategorie2 = new Categorie("AntiFongiques");
        DataAntibio.lesCategories.add(uneCategorie2);
        Categorie uneCategorie3 = new Categorie("Antiviraux");
        DataAntibio.lesCategories.add(uneCategorie3);
        Categorie uneCategorie4 = new Categorie("Carbapénèmes");
        DataAntibio.lesCategories.add(uneCategorie4);
        Categorie uneCategorie5 = new Categorie("Céphalosporines");
        DataAntibio.lesCategories.add(uneCategorie5);
        Categorie uneCategorie6 = new Categorie("Macrolides");
        DataAntibio.lesCategories.add(uneCategorie6);
        Categorie uneCategorie7 = new Categorie("Pénicillines");
        DataAntibio.lesCategories.add(uneCategorie7);
        Categorie uneCategorie8 = new Categorie("Quinolones");
        DataAntibio.lesCategories.add(uneCategorie8);
        Categorie uneCategorie9 = new Categorie("Sulfamidés");
        DataAntibio.lesCategories.add(uneCategorie9);
        Categorie uneCategorie10 = new Categorie("Autres");
        DataAntibio.lesCategories.add(uneCategorie10);

        DataAntibio.lesAntibiotiques = new ArrayList<Antibiotique>();
        AntibioParKilo unAntibioParKilo;
        AntibioParPrise unAntibioParPrise;
        unAntibioParPrise = new AntibioParPrise("Fluconazole", "mg", uneCategorie2,300,1);
        DataAntibio.lesAntibiotiques.add(unAntibioParPrise);
        unAntibioParKilo = new AntibioParKilo("Amiklin","mg",uneCategorie1,15);
        DataAntibio.lesAntibiotiques.add(unAntibioParKilo);
        unAntibioParKilo = new AntibioParKilo("Garamycine", "mg",uneCategorie1,6);
        DataAntibio.lesAntibiotiques.add(unAntibioParKilo);
    }
    static public List<Categorie> getLesCategories()    {
         return DataAntibio.lesCategories;
    }

    static public List<Antibiotique> getAntibiotiquesUneCateg(Categorie c) {
        DataAntibio.lesAntibiotiquesUneCateg = new ArrayList<Antibiotique>();
        for (Antibiotique a : DataAntibio.lesAntibiotiques){
            if (a.getCategorie() == c){
                DataAntibio.lesAntibiotiquesUneCateg.add(a);
            }
        }
    return DataAntibio.lesAntibiotiquesUneCateg;
    }

    static public float getMoyenneDoseKilo(String unite){
        float moyenneDoseKilo = 0;
        int compteur = 0;
        for (Antibiotique a : DataAntibio.lesAntibiotiques){
            if (a instanceof AntibioParKilo){
                moyenneDoseKilo += ((AntibioParKilo) a).getDoseKilo();
                compteur++;
            }
        }
        moyenneDoseKilo = moyenneDoseKilo/compteur;
        return moyenneDoseKilo;
    }
}
