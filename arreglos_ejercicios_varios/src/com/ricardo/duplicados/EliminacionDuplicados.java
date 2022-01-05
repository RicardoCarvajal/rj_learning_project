package com.ricardo.duplicados;

import java.util.Arrays;
import java.util.Scanner;

public class EliminacionDuplicados {

    private int repositorio[] = new int[5];

    public int[] getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(int[] repositorio) {
        this.repositorio = repositorio;
    }

    public void evaluaDuplicado() {

        Scanner entrada = new Scanner(System.in);

        int x = 0;

        System.out.println("Por favor ingrese los numeros solicitados\n");

        for (int i = repositorio.length; i > 0; i--) {

            x++;

            System.out.println("Por favor ingrese el numero: " + (x));

            int numero = entrada.nextInt();

            Arrays.sort(repositorio);

            int ubicacion = Arrays.binarySearch(repositorio, numero);

            if (ubicacion >= 0) {
                System.out.println("numero repetido ");
            } else {
                repositorio[0] = numero;
                System.out.println("numero: " + numero + " gravado\n");
            }

        }

        System.out.println("Numeros ingresados\n");
        Arrays.sort(repositorio);
        for (int numeros : repositorio)
            if (numeros > 0)
                System.out.println(numeros + "\n");

        entrada.close();

    }

}
