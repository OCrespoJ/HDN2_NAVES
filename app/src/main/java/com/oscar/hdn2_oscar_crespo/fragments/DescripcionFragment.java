package com.oscar.hdn2_oscar_crespo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.oscar.hdn2_oscar_crespo.R;

public class DescripcionFragment extends Fragment implements View.OnClickListener {

    private Button btnCompartirDescripcion;
    private TextView tituloDescripcion1, tituloDescripcion2, tituloDescripcion3;
    private TextView rellenoDescripcion1, rellenoDescripcion2, rellenoDescripcion3;

    public static DescripcionFragment newInstance() {//los fragment siempre se crean con newInstance
        return new DescripcionFragment();

    }

    public DescripcionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_descripcion, container, false);

        tituloDescripcion1 = (TextView) view.findViewById(R.id.tituloDescripcion1);
        tituloDescripcion2 = (TextView) view.findViewById(R.id.tituloDescripcion2);
        tituloDescripcion3 = (TextView) view.findViewById(R.id.tituloDescripcion3);
        rellenoDescripcion1 = (TextView) view.findViewById(R.id.rellenoDescripcion1);
        rellenoDescripcion2 = (TextView) view.findViewById(R.id.rellenoDescripcion2);
        rellenoDescripcion3 = (TextView) view.findViewById(R.id.rellenoDescripcion3);
        btnCompartirDescripcion = (Button) view.findViewById(R.id.btnCompartirDescripcion);

        btnCompartirDescripcion.setOnClickListener(this);
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

    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,
                rellenoDescripcion1.getText()+" "+
                rellenoDescripcion2.getText()+" "+
                rellenoDescripcion3.getText());
        startActivity(Intent.createChooser(intent, "Compartir por:"));

    }
}
