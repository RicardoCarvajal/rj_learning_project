package com.ricardo.inicializacion_de_arreglos;

public class IniciaArreglos {

    public static void main(String[] args) {

        int[] arreglo;

        arreglo = new int[10];

        System.out.printf("%s%8s\n", "Indice", "Valor");

        for (int contador = 0; contador < arreglo.length; contador++) {

            System.out.printf("%5d%8d\n", contador, arreglo[contador]);

        }

    }

}
