package com.oscar.hdn2_oscar_crespo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oscar.hdn2_oscar_crespo.beans.TrucoBean;
import com.oscar.hdn2_oscar_crespo.fragments.TrucoFragment;

public class TrucosActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    private TextView txtNombre, txtDescripcion;
    private Button btnCompartirTrucos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trucos);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TrucoBean  trucoBean = (TrucoBean) getIntent().getSerializableExtra(TrucoFragment.TRUCO_KEY);

        txtNombre = (TextView) findViewById(R.id.txtNombreTruco);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcionTruco);
        btnCompartirTrucos = (Button) findViewById(R.id.btnCompartirTrucos);

        txtNombre.setText(trucoBean.getNombre());
        txtDescripcion.setText(trucoBean.getDescripcion());

        btnCompartirTrucos.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, txtDescripcion.getText());
        startActivity(Intent.createChooser(intent, "Compartir por:"));

    }
}
