package com.example.sabine.projetantibio2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabine.projetantibio2019.mesClasses.AntibioParKilo;
import com.example.sabine.projetantibio2019.mesClasses.Antibiotique;

import java.io.Serializable;


public class Main3Activity extends AppCompatActivity {

    AntibioParKilo antSelected;
    TextView masseView, viewResult, textView, textView2;
    Button buttonCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        antSelected = (AntibioParKilo) args.getSerializable("antSelected");
        masseView = (TextView) findViewById(R.id.masseView);
        viewResult = (TextView) findViewById(R.id.viewResult);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        buttonCalculer = (Button) findViewById(R.id.buttonCalculer);
        buttonCalculer.setOnClickListener(clickListenerBtnCalculer);
    }

    private View.OnClickListener clickListenerBtnCalculer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{ String masse = masseView.getText().toString();
            int quantite = Integer.parseInt(masseView.getText().toString());
            String resultat = Integer.toString(antSelected.getDoseKilo()*quantite);
            viewResult.setText("La posologie est de "+resultat+" mg");
        } catch (Exception e){
                Toast.makeText(Main3Activity.this,"Veuillez saisir une valeur valide", Toast.LENGTH_LONG).show();
            };
        }};
}
