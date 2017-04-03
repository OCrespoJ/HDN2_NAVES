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

import com.oscar.hdn2_oscar_crespo.ObjetosActivity;
import com.oscar.hdn2_oscar_crespo.R;

import java.util.ArrayList;

import com.oscar.hdn2_oscar_crespo.adapters.ObjetosAdapter;
import com.oscar.hdn2_oscar_crespo.beans.ObjetosBean;
import com.oscar.hdn2_oscar_crespo.modelos.ModelosObjetos;

public class ObjetosFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView listObjetos;
    private ArrayList<ObjetosBean> objetos;
    public static final String OBJETO_KEY = "OBJETO_KEY";

    public ObjetosFragment() {
        // Required empty public constructor
    }

    public static ObjetosFragment newInstance() {
        return new ObjetosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_objetos, container, false);
        listObjetos = (ListView) view.findViewById(R.id.listObjetos);
        objetos = ModelosObjetos.getObjeto();

        //Ponemos el adapter
        ObjetosAdapter adapter = new ObjetosAdapter(getActivity(), R.layout.item_objeto, objetos);
        listObjetos.setAdapter(adapter);

        listObjetos.setOnItemClickListener(this);
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
        ObjetosBean objetosBean = objetos.get(posicion);
        Intent intent = new Intent(getActivity(), ObjetosActivity.class);
        intent.putExtra(OBJETO_KEY, objetosBean);
        startActivity(intent);
    }
}
