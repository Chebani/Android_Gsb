package com.example.sabine.projetantibio2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sabine.projetantibio2019.mesClasses.AntibioParKilo;
import com.example.sabine.projetantibio2019.mesClasses.AntibioParPrise;
import com.example.sabine.projetantibio2019.mesClasses.Antibiotique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView lstAntibio;
    List<Antibiotique> antibioUneCateg;
    private static final int MYTHIRDACTIVITY_REQUESTCODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lstAntibio = (ListView) findViewById(R.id.lstAntibio);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        antibioUneCateg = (List<Antibiotique>) args.getSerializable("myList");
        ArrayList<String> antibio = new ArrayList<String>();
        for(Antibiotique ant : antibioUneCateg){
            antibio.add(ant.getLibelle().toUpperCase());
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1, antibio);
        lstAntibio.setAdapter(adapter);
        lstAntibio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Antibiotique antSelected = antibioUneCateg.get(position);
                if (antSelected instanceof AntibioParKilo){
                    Intent it = new Intent(Main2Activity.this, Main3Activity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("antSelected", (Serializable) antSelected);
                    it.putExtra("bundle", args);
                    startActivityForResult(it, MYTHIRDACTIVITY_REQUESTCODE);
                } if(antSelected instanceof AntibioParPrise) {
                   String result =  "La posologie du "+antSelected.getLibelle()+" est de "+((AntibioParPrise) antSelected).getDosePrise()+" mg "+((AntibioParPrise) antSelected).getNombre()+" fois par jour";
                   Toast.makeText(Main2Activity.this,result, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
