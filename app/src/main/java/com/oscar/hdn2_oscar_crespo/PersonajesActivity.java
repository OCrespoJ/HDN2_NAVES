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

import com.oscar.hdn2_oscar_crespo.beans.PersonajeBean;
import com.oscar.hdn2_oscar_crespo.fragments.PersonajesFragment;

public class PersonajesActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    private ImageView imgPersonaje;
    private TextView txtNombre, txtDescripcion, txtCaracteristicas;
    private Button btnCompartirPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PersonajeBean personajeBean = (PersonajeBean) getIntent().getSerializableExtra(PersonajesFragment.PERSONAJE_KEY);

        imgPersonaje = (ImageView) findViewById(R.id.imgPersonaje);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtCaracteristicas = (TextView) findViewById(R.id.txtCaracteristicas);
        btnCompartirPersonajes = (Button) findViewById(R.id.btnCompartirPersonajes);

        imgPersonaje.setImageDrawable(ContextCompat.getDrawable(this, personajeBean.getFoto()));
        txtNombre.setText(personajeBean.getNombre());
        txtDescripcion.setText(personajeBean.getDescripcion());
        txtCaracteristicas.setText(personajeBean.getCaracteristicas());

        btnCompartirPersonajes.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, txtDescripcion.getText()+" "+txtCaracteristicas.getText());
        startActivity(Intent.createChooser(intent, "Compartir por:"));

    }
}
