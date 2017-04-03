package com.oscar.hdn2_oscar_crespo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.oscar.hdn2_oscar_crespo.PersonajesActivity;
import com.oscar.hdn2_oscar_crespo.R;

import java.util.ArrayList;

import com.oscar.hdn2_oscar_crespo.beans.PersonajeBean;
import com.oscar.hdn2_oscar_crespo.modelos.ModelosPersonajes;
import com.oscar.hdn2_oscar_crespo.adapters.PersonajesAdapter;

public class PersonajesFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView listPersonajes;
    private ArrayList<PersonajeBean> personajes;
    public static final String PERSONAJE_KEY = "PERSONAJE_KEY";

    public PersonajesFragment() {
        // Required empty public constructor
    }

    public static PersonajesFragment newInstance() {
        return new PersonajesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personajes, container, false);
        listPersonajes = (ListView) view.findViewById(R.id.listPersonajes);
        personajes = ModelosPersonajes.getPersonaje();

        //Ponemos el adapter
        PersonajesAdapter adapter = new PersonajesAdapter(getActivity(), R.layout.item_personaje, personajes);
        listPersonajes.setAdapter(adapter);

        listPersonajes.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        PersonajeBean personajeBean = personajes.get(posicion);
        Intent intent = new Intent(getActivity(), PersonajesActivity.class);
        intent.putExtra(PERSONAJE_KEY, personajeBean);
        startActivity(intent);
    }
}
