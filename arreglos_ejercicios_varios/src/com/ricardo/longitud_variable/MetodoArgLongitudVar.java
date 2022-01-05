package com.ricardo.longitud_variable;

public class MetodoArgLongitudVar {

    public void producto(int... producto) {

        int numeroFinal = 1;

        for (int multiplica : producto)
            numeroFinal = numeroFinal * multiplica;

        System.out.println("El resultado es: " + numeroFinal);

    }

}
