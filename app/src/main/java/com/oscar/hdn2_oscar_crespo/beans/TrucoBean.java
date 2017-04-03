package com.oscar.hdn2_oscar_crespo.beans;

import java.io.Serializable;

/**
 * Created by oscar on 30/03/2017.
 */

public class TrucoBean implements Serializable {
    private String nombre;
    private String descripcion;

    public TrucoBean(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
}
