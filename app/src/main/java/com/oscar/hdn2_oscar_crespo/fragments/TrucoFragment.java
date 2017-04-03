package com.oscar.hdn2_oscar_crespo.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.oscar.hdn2_oscar_crespo.R;
import com.oscar.hdn2_oscar_crespo.TrucosActivity;
import com.oscar.hdn2_oscar_crespo.adapters.TrucosAdapter;
import com.oscar.hdn2_oscar_crespo.beans.TrucoBean;
import com.oscar.hdn2_oscar_crespo.modelos.ModelosTrucos;

import java.util.ArrayList;

public class TrucoFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView listTrucos;
    private ArrayList<TrucoBean> trucos;
    public static final String TRUCO_KEY = "TRUCO_KEY";

    public TrucoFragment() {
        // Required empty public constructor
    }

    public static TrucoFragment newInstance() {
        return new TrucoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_truco, container, false);
        listTrucos = (ListView) view.findViewById(R.id.listTrucos);
        trucos = ModelosTrucos.getTrucos();

        //Ponemos el adapter
        TrucosAdapter adapter = new TrucosAdapter(getActivity(), R.layout.item_truco, trucos);
        listTrucos.setAdapter(adapter);

        listTrucos.setOnItemClickListener(this);
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
        TrucoBean trucoBean = trucos.get(posicion);
        Intent intent = new Intent(getActivity(), TrucosActivity.class);
        intent.putExtra(TRUCO_KEY, trucoBean);
        startActivity(intent);
    }
}
