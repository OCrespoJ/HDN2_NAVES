package com.oscar.hdn2_oscar_crespo.beans;

import java.io.Serializable;

public class PersonajeBean implements Serializable {
    private int foto;
    private String nombre;
    private String descripcion;
    private String caracteristicas;

    public PersonajeBean(int foto, String nombre, String descripcion, String caracteristicas) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
