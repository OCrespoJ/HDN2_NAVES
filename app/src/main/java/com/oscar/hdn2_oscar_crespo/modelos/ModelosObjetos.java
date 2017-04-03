package com.oscar.hdn2_oscar_crespo.modelos;

import com.oscar.hdn2_oscar_crespo.R;

import java.util.ArrayList;

import com.oscar.hdn2_oscar_crespo.beans.ObjetosBean;

/**
 * Created by oscar on 17/03/2017.
 */

public class ModelosObjetos {
    public static ArrayList<ObjetosBean> getObjeto () {
        ArrayList<ObjetosBean> objetos = new ArrayList<>();

        objetos.add(new ObjetosBean(
                R.drawable.vida,
                "Esfera de puntuación",
                "Esta esfera sumará X puntos a nuestro marcador."));
        objetos.add(new ObjetosBean(
                R.drawable.vida,
                "Esfera de vida",
                "Con esta esfera podremos curarnos una cantidad de vida."));
        objetos.add(new ObjetosBean(
                R.drawable.vida,
                "Esfera de velocidad",
                "Con esta esfera podremos movernos más rápido durante X tiempo."));
        objetos.add(new ObjetosBean(
                R.drawable.vida,
                "Esfera de invulnerabilidad",
                "Al coger esta esfera nos volveremos invulnerables durante X tiempo."));
        objetos.add(new ObjetosBean(
                R.drawable.vida,
                "Caja de munición explosiva",
                "Al coger esta caja nuestra nave disparará unas balas que al chocar dañarán a varios enemigos. Tendremos una cantidad limitada y después volveremos a tener munición normal"));
        objetos.add(new ObjetosBean(
                R.drawable.vida,
                "Caja de munición pesada",
                "Con esta munición haremos más daño."));


        return objetos;
    }
}
