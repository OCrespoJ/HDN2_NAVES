package com.oscar.hdn2_oscar_crespo.modelos;

import com.oscar.hdn2_oscar_crespo.R;

import java.util.ArrayList;

import com.oscar.hdn2_oscar_crespo.beans.PersonajeBean;

public class ModelosPersonajes {
    public static ArrayList <PersonajeBean> getPersonaje () {
        ArrayList<PersonajeBean> personajes = new ArrayList<>();

        personajes.add(new PersonajeBean(
                R.drawable.prota,
                "Protagonista",
                "Esta es la nave que controlaremos nosotros. Es una rápida nave de carreras" +
                        "que usaremos para acabar con todos los enemigos. " +
                        "Podremos movernos arriba y abajo " +
                        " con las flechas del teclado y disparar pulsando el boton espacio",
                "Esta nave dispondrá de 10 vidas y unas balas láser con una velocidad normal y un daño bajo." +
                        "Podrá tener más tipos de balas recogiendo esferas por el mapa, como pueden ser " +
                        "disparos explisivos, rápidos, o bombas"));
        personajes.add(new PersonajeBean(
                R.drawable.enemy,
                "Enemigo",
                "Esta es la nave que usarán los enemigos más débiles. Nuestro objetivo será abatir " +
                        "a tantas de estas naves como podamos para poder enfrentarnos al " +
                        "boss final.",
                "Estos enemigos dispondrán solo de 1 vida, y dispondrán de unos disparos normales, " +
                        "como los que tiene nuestra nave al principio"));
        personajes.add(new PersonajeBean(
                R.drawable.boss,
                "Boss",
                "Es el enemigo más poderoso, mucho más grande que los enemigos normales, más fuerte " +
                        "y con ataques especiales. Deberemos derrotarlo para ganar la partida",
                "El boss dispondrán de 500 de vida, y podrá disparar balas de muchos tipos. Es el enemigo más difícil de derrotar"));

        return personajes;
    }
}
