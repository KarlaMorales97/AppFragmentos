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
            imagen = getResources().getStringArray(R.array.num);
            return view;

        }


        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.Nombre_Comida, android.R.layout.simple_list_item_1);;
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            Comidas comiditas = new Comidas(Nombre[i], Calorias[i], Colesterol[i], imagen[i]);


            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("FOODKEY", comiditas);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){


                FragmentViewer frag = new FragmentViewer();
                Bundle bundle = new Bundle();
                bundle.putSerializable("FOODKEY",comiditas);
                frag.setArguments(bundle);

                final FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.viewer, frag);
                fragmentTransaction.commit();
            }


        }
    }
