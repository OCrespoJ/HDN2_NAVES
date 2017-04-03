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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail, editPass;
    private Button btnEnviar, btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Preferencias preferencias = new Preferencias(LoginActivity.this);

        //La primera vez que entremos siempre sera false porque no tendremos datos guardados
        if(preferencias.isLogin() == false){

            editEmail = (EditText) findViewById(R.id.editEmail);
            editPass = (EditText) findViewById(R.id.editPass);
            btnEnviar = (Button) findViewById(R.id.btnEnviar);
            btnNuevo = (Button) findViewById(R.id.btnNuevo);

            btnEnviar.setOnClickListener(this);
            btnNuevo.setOnClickListener(this);
        }else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnEnviar:
                //validar datos
                String email = editEmail.getText().toString();
                String pass = editPass.getText().toString();

                if(email != null && pass != null && !email.isEmpty() && !pass.isEmpty()){
                    Preferencias preferencias = new Preferencias(LoginActivity.this);
                    UsuarioBean usuarioBean = preferencias.getUsuario();
                    //Si el usuario existe y es igual que el registrado
                    if(usuarioBean.getCorreo() != null){
                        if(email.equals(usuarioBean.getCorreo()) && pass.equals(usuarioBean.getPass())){
                            preferencias.setLogin(true);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Datos incorrectos, ", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "No existe el usuario, ", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnNuevo:
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                break;

        }
    }
}
