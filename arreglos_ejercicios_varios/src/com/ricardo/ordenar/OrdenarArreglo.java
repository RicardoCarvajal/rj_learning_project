package com.ricardo.ordenar;

public class OrdenarArreglo {

    private int[][] ventas = new int[3][5];

    public void etiquetaArreglo() {

        int sumador = 1;

        for (int fila = 0; fila < ventas.length; fila++) {

            if (fila > 0)

                sumador = sumador + 5;

            for (int col = 0; col < ventas[fila].length; col++) {

                ventas[fila][col] = 0;

                int etiqueta = col + sumador;

                System.out.printf("%s%s\t", ventas[fila][col], "(" + etiqueta + ")");

            }

            System.out.println("\n");

        }

    }

}
