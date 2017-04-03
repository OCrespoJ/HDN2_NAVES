package com.oscar.hdn2_oscar_crespo.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.oscar.hdn2_oscar_crespo.MainActivity;
import com.oscar.hdn2_oscar_crespo.Preferencias.Preferencias;
import com.oscar.hdn2_oscar_crespo.R;
import com.oscar.hdn2_oscar_crespo.beans.UsuarioBean;

import java.io.InputStream;

import static com.oscar.hdn2_oscar_crespo.R.id.imgFotoPerfil;
import static com.oscar.hdn2_oscar_crespo.R.id.navView;

public class PerfilFragment extends Fragment implements View.OnClickListener {

    private TextView nombre, correo, usuario;
    private Button btnFoto;
    private ImageView imgFotoPerfil;
    private int SELECT_FILE;


    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment newInstance() {//los fragment siempre se crean con newInstance
        return new PerfilFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        Preferencias preferencias = new Preferencias(getActivity());

        nombre = (TextView) view.findViewById(R.id.nombre);
        correo = (TextView) view.findViewById(R.id.correo);
        usuario = (TextView) view.findViewById(R.id.usuario);
        btnFoto = (Button) view.findViewById(R.id.btnFoto);
        imgFotoPerfil = (ImageView) view.findViewById(R.id.imgFotoPerfil);
        SELECT_FILE = 1;

        UsuarioBean usuarioBean = preferencias.getUsuario();

        nombre.setText(usuarioBean.getUsuario());
        correo.setText(usuarioBean.getCorreo());
        usuario.setText(usuarioBean.getNombre());

        btnFoto.setOnClickListener(this);

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
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(
                Intent.createChooser(intent, "Seleccione una imagen"), SELECT_FILE);

    }

}
