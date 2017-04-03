package com.oscar.hdn2_oscar_crespo.Preferencias;

import android.content.Context;
import android.content.SharedPreferences;

import com.oscar.hdn2_oscar_crespo.beans.UsuarioBean;

/**
 * Created by ALUMNOS on 31/03/2017.
 */

public class Preferencias {
    private Context context;
    private final String PREFERENCIAS = "preferencias";
    private final String LOGIN = "login";
    private final String USUARIO = "usuario";

    public Preferencias(Context context) {
        this.context = context;
    }

    public void setUsuario (UsuarioBean usuario){
        String usuarioJson = usuario.toJson();

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //con esto podremos modificar las preferencias

        editor.putString(USUARIO, usuarioJson);
        editor.commit();
    }

    public UsuarioBean getUsuario(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, context.MODE_PRIVATE);
        String usuariojson = sharedPreferences.getString(USUARIO, "");
        return UsuarioBean.fromJson(usuariojson);
    }

    public void setLogin(boolean login){
        //Creamos una preferencia que solo pueda leer nuestra aplicacion.
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //con esto podremos modificar las preferencias

        editor.putBoolean(LOGIN, login);

        //ESTO ES PARA CONFIRMAR EL CAMBIO, SI NO LO PONEMOS ESTO NO HABREMOS CAMBIADO NADA
        editor.commit();
    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCIAS, context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(LOGIN, false);
    }
}
