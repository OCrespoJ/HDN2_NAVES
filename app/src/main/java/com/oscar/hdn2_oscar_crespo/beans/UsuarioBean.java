package com.oscar.hdn2_oscar_crespo.beans;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 31/03/2017.
 */

public class UsuarioBean implements Serializable{
    private String nombre, correo, usuario, pass;

    public UsuarioBean() {
    }

    public UsuarioBean(String nombre, String correo, String usuario, String pass) {
        this.correo = correo;
        this.nombre = nombre;
        this.pass = pass;
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    //Con este metodo convertiremos el objeto en json para poder pasarlo en un string. Al poner this decimos que convierta este usuario
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static UsuarioBean fromJson (String json){
        if(json != null && !json.isEmpty()){
            Gson gson = new Gson();
            return gson.fromJson(json, UsuarioBean.class);
        }else{
            return new UsuarioBean();
        }
    }
}
