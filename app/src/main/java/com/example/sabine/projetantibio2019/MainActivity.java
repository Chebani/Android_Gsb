package com.example.sabine.projetantibio2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sabine.projetantibio2019.mesClasses.Antibiotique;
import com.example.sabine.projetantibio2019.mesClasses.Categorie;
import com.example.sabine.projetantibio2019.mesClasses.DataAntibio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstCategorie;
    List<Categorie> lesCategories;
    List<Antibiotique> antibioUneCateg;
    private static final int MYSECONDACTIVITY_REQUESTCODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstCategorie = (ListView) findViewById(R.id.lstCateg);
        DataAntibio.initialiser();
        lesCategories = DataAntibio.getLesCategories();
        // alimentation de la ListView
        ArrayList<String> categ = new ArrayList<String>();
        for(Categorie c : lesCategories){
            categ.add(c.getLibelle().toUpperCase());
        }
        //Adaptateur pour faire le lien entre la list du programme et la liste de l'interface
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, categ);
        lstCategorie.setAdapter(adapter);

        // gestion sélection sur la ListView
        lstCategorie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Categorie categorie = lesCategories.get(position);
                antibioUneCateg = DataAntibio.getAntibiotiquesUneCateg(categorie);
                Intent it = new Intent(MainActivity.this, Main2Activity.class);
                Bundle args = new Bundle();
                args.putSerializable("myList", (Serializable) antibioUneCateg);
                it.putExtra("bundle", args);
                startActivityForResult(it, MYSECONDACTIVITY_REQUESTCODE);
                }
        });
    }
}
