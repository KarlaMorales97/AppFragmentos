package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();






        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null){
            if (intentType.equals("text/plain")){
                handleReceivedText(callingIntent);
            }
        }

    }

    private void handleReceivedText(Intent intent){
        Comidas comidas = intent.getParcelableExtra("Prueba");
        int img = comidas.getImagen();
        String nombre = comidas.getNombre_Comida();
        String calorias = comidas.getCalorias();
        String colesterol = comidas.getColesterol();

        ImageView imageView = findViewById(R.id.imagen_comidas_acativity2);
        imageView.setImageResource(img);


        if(comidas != null) {
            TextView texto1 = findViewById(R.id.text1Id_activity2);
            texto1.setText(nombre);
            TextView texto2 = findViewById(R.id.text2Id_activity2);
            texto2.setText(calorias);
            TextView texto3 = findViewById(R.id.text3Id_activity2);
            texto3.setText(colesterol);
        }

    }
}
