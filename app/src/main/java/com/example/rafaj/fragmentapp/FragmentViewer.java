package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    TextView text;
    TextView text2;
    TextView text3;
    ImageView imagen_comida;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.TextId1);
        text2 = view.findViewById(R.id.TextId2);
        text3 = view.findViewById(R.id.TextId3);
        imagen_comida = view.findViewById(R.id.imagenes_comida);

        Bundle bundle = this.getArguments();


        if(bundle != null){
            Comidas comiditas = (Comidas)bundle.getSerializable("FOODKEY");

            Resources resources = getResources();
            TypedArray imagenes = resources.obtainTypedArray(R.array.pictures_array);
            Drawable drawable = imagenes.getDrawable(Integer.parseInt(comiditas.getImagen()));


            text.setText(comiditas.getNombre_Comida());
            text2.setText(comiditas.getCalorias());
            text3.setText(comiditas.getColesterol());
            imagen_comida.setImageDrawable(drawable);
        }

        return view;
    }


}
