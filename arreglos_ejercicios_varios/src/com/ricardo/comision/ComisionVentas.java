package com.ricardo.comision;

public class ComisionVentas {

    private double ventaSemanal[];

    private int ventaTabulada[] = new int[9];

    private final double SUELDOVENDEDOR = 200;

    private final double PORCENTAJECOMISION = 0.09;

    public ComisionVentas(double[] ventaSemanal) {
        this.ventaSemanal = ventaSemanal;
    }

    public double[] getVentaSemanal() {
        return ventaSemanal;
    }

    public void setVentaSemanal(double[] ventaSemanal) {
        this.ventaSemanal = ventaSemanal;
    }

    public void mostrarVentasTabuladas() {

        int parametros = 2;

        System.out.printf("%s%11s\n\n", "Parametro", "Cantidad");

        for (double venta : ventaTabulada) {

            String tabulador = "";

            for (int i = 1; i <= venta; i++) {

                tabulador = tabulador + "*";

            }

            System.out.printf("%s%s%s%s%12s\n", parametros * 100, "-",
                              parametros < 10 ? (parametros * 100) + 99 : " >", " ", tabulador);

            parametros++;

        }

    }

    public void tabularVentas() {

        for (double venta : ventaSemanal) {

            String ventaIndicador;

            ventaIndicador = String.valueOf(Math.round((venta * PORCENTAJECOMISION + SUELDOVENDEDOR) / 100));

            switch (ventaIndicador) {
                case "2":

                    ventaTabulada[0]++;

                    break;

                case "3":

                    ventaTabulada[1]++;

                    break;

                case "4":

                    ventaTabulada[2]++;

                    break;

                case "5":

                    ventaTabulada[3]++;

                    break;

                case "6":

                    ventaTabulada[4]++;

                    break;

                case "7":

                    ventaTabulada[5]++;

                    break;

                case "8":

                    ventaTabulada[6]++;

                    break;

                case "9":

                    ventaTabulada[7]++;

                    break;

                default:

                    ventaTabulada[8]++;

                    break;
            }

        }

    }

}
