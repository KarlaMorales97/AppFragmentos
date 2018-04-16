package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView texto1, texto2, texto3;
    ImageView imagen;
    Bundle bundle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        texto1 = findViewById(R.id.TextId1);
        texto2 = findViewById(R.id.TextId2);
        texto3 = findViewById(R.id.TextId3);
        imagen = findViewById(R.id.imagen_comidas);

        Intent callingIntent = this.getIntent();
        bundle = callingIntent.getExtras();


        Comidas comida = (Comidas)bundle.getSerializable("FOODKEY");

        Resources resources = getResources();
        TypedArray imagenes = resources.obtainTypedArray(R.array.pictures_array);
        Drawable drawable = imagenes.getDrawable(Integer.parseInt(comida.getImagen()));

        texto1.setText(comida.getNombre_Comida());
        texto2.setText(comida.getCalorias());
        texto3.setText(comida.getColesterol());
        imagen.setImageDrawable(drawable);


        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();
    }

}
