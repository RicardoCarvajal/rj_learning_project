package com.ricardo.operaciones;

import java.util.Arrays;

public class OperacionesArreglos {

    private int[] cuentas = new int[10];

    private int[] bono = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
            1000};

    private int[] mejoresPuntuaciones = {8, 9, 8, 10, 8};

    public int[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(int[] cuentas) {
        this.cuentas = cuentas;
    }

    public int[] getBono() {
        return bono;
    }

    public void setBono(int[] bono) {
        this.bono = bono;
    }

    public int[] getMejoresPuntuaciones() {
        return mejoresPuntuaciones;
    }

    public void setMejoresPuntuaciones(int[] mejoresPuntuaciones) {
        this.mejoresPuntuaciones = mejoresPuntuaciones;
    }

    public void asignarCerosMostrar() {

        Arrays.fill(cuentas, 0);

        for (int cuenta : cuentas)
            System.out.print(cuenta + " ");
        System.out.println("\n");

    }

    public void sumarBonoMostrar() {

        Arrays.fill(bono, 15);

        for (int b : bono)
            System.out.print(b + " ");
        System.out.println("\n");
    }

    public void mejoresPuntuacionesMostrar() {
        int i = 1;
        for (int puntuacion : mejoresPuntuaciones)
            System.out.println((i++) + " " + puntuacion + "\n");

    }

}
