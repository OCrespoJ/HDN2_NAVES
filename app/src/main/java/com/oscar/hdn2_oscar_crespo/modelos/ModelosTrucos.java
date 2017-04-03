package com.oscar.hdn2_oscar_crespo.modelos;

import com.oscar.hdn2_oscar_crespo.R;
import com.oscar.hdn2_oscar_crespo.beans.TrucoBean;

import java.util.ArrayList;

/**
 * Created by oscar on 30/03/2017.
 */

public class ModelosTrucos {
    public static ArrayList<TrucoBean> getTrucos () {
        ArrayList<TrucoBean> trucos = new ArrayList<>();

        trucos.add(new TrucoBean(
                "Conseguir más puntuación",
                "Conseguiremos puntuación si matamos enemigos. Podremos aumentar esta puntuación " +
                        "recogiendo las esferas de puntuación, que nos darán más puntos si la " +
                        "dificultad es mayor."));
        trucos.add(new TrucoBean(
                "Como moverse",
                "Usaremos el teclado para movernos. Para que sea más difícil matarnos, tendremos " +
                        "que movernos continuamente, asi los enemigos fallarán sus disparos."));
        trucos.add(new TrucoBean(
                "Derrotar al boss",
                "Para derrotar al boss tendremos que ser pacientes: tiene mucha más fuerza y vida que nosotros, " +
                        "por lo que tendremos que esperar a la situación perfecta para atacar sin peligro."));

        return trucos;
    }
}
