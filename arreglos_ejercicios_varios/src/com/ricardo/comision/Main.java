package com.ricardo.comision;

public class Main {

    public static void main(String[] args) {

        double ventas[] = {5000, 10000, 550, 1963, 1236, 8000, 462, 450};

        ComisionVentas ventaTabuladas = new ComisionVentas(ventas);

        ventaTabuladas.tabularVentas();

        ventaTabuladas.mostrarVentasTabuladas();

    }

}
