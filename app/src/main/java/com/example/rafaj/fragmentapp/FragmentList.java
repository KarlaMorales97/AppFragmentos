package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{


        Comidas Objeto_comida;
        Comidas Hamburguesa;
        Comidas Pizza;
        Comidas Tacos;
        Comidas Salsa_ketchup, pollo_asado, papas_fritas, donas,got_dog;

        private String[] Nombre;
        private String[] Calorias;
        private String[] Colesterol;
        private String[] imagen;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.list_fragment, container, false);

            Nombre = getResources().getStringArray(R.array.Nombre_Comida);
            Calorias = getResources().getStringArray(R.array.Calorias_Array);
            Colesterol = getResources().getStringArray(R.array.Colesterol_Array);
            imagen = getResources().getStringArray(R.array.pictures_array);
            return view;

        }


        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.Comidas, android.R.layout.simple_list_item_1);;
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
                newIntent.setAction(Intent.ACTION_SEND);
                newIntent.putExtra(Intent.EXTRA_TEXT, adapterView.getItemAtPosition(i).toString());
                startActivity(newIntent);
            }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

                Bundle bundle = new Bundle();
                FragmentViewer frag = new FragmentViewer();
                frag.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.viewer, frag);
                fragmentTransaction.commit();
            }


        }
    }
