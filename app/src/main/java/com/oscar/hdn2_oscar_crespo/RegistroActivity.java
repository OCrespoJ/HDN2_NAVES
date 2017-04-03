package com.oscar.hdn2_oscar_crespo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oscar.hdn2_oscar_crespo.Preferencias.Preferencias;
import com.oscar.hdn2_oscar_crespo.beans.UsuarioBean;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editEmail, editNombre, editUsuario, editPass, editConfirmPass;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editPass = (EditText) findViewById(R.id.editPass);
        editConfirmPass = (EditText) findViewById(R.id.editConfirmPass);

        btnFinalizar = (Button) findViewById(R.id.btnGuardar);

        btnFinalizar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = editEmail.getText().toString();
        String nombre = editNombre.getText().toString();
        String apellidos = editUsuario.getText().toString();
        String pass = editPass.getText().toString();
        String confirmPass = editConfirmPass.getText().toString();

        if(email != null && nombre != null && apellidos != null && pass != null && confirmPass != null &&
                !email.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() && !pass.isEmpty() && !confirmPass.isEmpty()){

            UsuarioBean usuarioBean = new UsuarioBean(apellidos, email, nombre, pass);


            Preferencias preferencias = new Preferencias(RegistroActivity.this);
            preferencias.setUsuario(usuarioBean);

            Toast.makeText(RegistroActivity.this, "El usuario se ha registrado correctamente", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(RegistroActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
        }

    }
}
