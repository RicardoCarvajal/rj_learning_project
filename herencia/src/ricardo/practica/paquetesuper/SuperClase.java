package ricardo.practica.paquetesuper;

import java.util.Random;

/*
 * Los campos o metodos protected solo pueden ser usados dentro de las clases del mismo
 * paquete o en las sub clases
 */

public class SuperClase {

    private final Integer NUMERO = 10;

    protected Random numeroAleatoreo = new Random();

    protected Integer getNumeroAleatoreo() {
        /* Se usa el campo en la misma clase */
        return numeroAleatoreo.nextInt(NUMERO);
    }

}
