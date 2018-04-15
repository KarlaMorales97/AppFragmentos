package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        text = view.findViewById(R.id.textId);
        imagen_comida = view.findViewById(R.id.imagenes_comida);
        Bundle bundle = this.getArguments();


        if(bundle != null){
            text.setText(bundle.getString("KEY_TEXT1"));
            imagen_comida.setImageResource(bundle.getInt("KEY_IMAGE"));
        }

        return view;
    }


}
