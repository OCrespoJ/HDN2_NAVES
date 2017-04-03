package com.oscar.hdn2_oscar_crespo;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscar.hdn2_oscar_crespo.beans.ObjetosBean;
import com.oscar.hdn2_oscar_crespo.fragments.ObjetosFragment;

public class ObjetosActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    private ImageView imgObjeto;
    private TextView txtNombre, txtDescripcion;
    private Button btnCompartirObjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetos);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ObjetosBean objetosBean = (ObjetosBean) getIntent().getSerializableExtra(ObjetosFragment.OBJETO_KEY);

        imgObjeto = (ImageView) findViewById(R.id.imgObjeto);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        btnCompartirObjetos = (Button) findViewById(R.id.btnCompartirObjetos);

        imgObjeto.setImageDrawable(ContextCompat.getDrawable(this, objetosBean.getFoto()));
        txtNombre.setText(objetosBean.getNombre());
        txtDescripcion.setText(objetosBean.getDescripcion());

        btnCompartirObjetos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, txtDescripcion.getText());
        startActivity(Intent.createChooser(intent, "Compartir por:"));

    }
}
