package com.ricardo.practica.generalidades;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class PanelDibujo extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Random numeroAleatorio = new Random();

    private MiLinea[] lineas;

    private MiOvalo[] ovalos;

    private MiRectangulo[] rectangulos;

    private static int cuenta;

    public PanelDibujo() {

        setBackground(Color.white);

        lineas = new MiLinea[5 + numeroAleatorio.nextInt(5)];

        ovalos = new MiOvalo[5 + numeroAleatorio.nextInt(5)];

        rectangulos = new MiRectangulo[5 + numeroAleatorio.nextInt(5)];

        for (int cuenta = 0; cuenta < lineas.length; cuenta++) {

            int x1 = numeroAleatorio.nextInt(300);
            int y1 = numeroAleatorio.nextInt(300);
            int x2 = numeroAleatorio.nextInt(300);
            int y2 = numeroAleatorio.nextInt(300);

            Color color = new Color(numeroAleatorio.nextInt(256), numeroAleatorio.nextInt(256),
                    numeroAleatorio.nextInt(256));

            lineas[cuenta] = new MiLinea(x1, y1, x2, y2, color);

        }

        for (int cuenta = 0; cuenta < ovalos.length; cuenta++) {

            int x1 = numeroAleatorio.nextInt(300);
            int y1 = numeroAleatorio.nextInt(300);
            int x2 = numeroAleatorio.nextInt(300);
            int y2 = numeroAleatorio.nextInt(300);

            Color color = new Color(numeroAleatorio.nextInt(256), numeroAleatorio.nextInt(256),
                    numeroAleatorio.nextInt(256));

            boolean flag = numeroAleatorio.nextBoolean();

            ovalos[cuenta] = new MiOvalo(x1, y1, x2, y2, color, flag);

            System.out.println(ovalos[cuenta].toString());

        }

        for (int cuenta = 0; cuenta < rectangulos.length; cuenta++) {

            int x1 = numeroAleatorio.nextInt(300);
            int y1 = numeroAleatorio.nextInt(300);
            int x2 = numeroAleatorio.nextInt(300);
            int y2 = numeroAleatorio.nextInt(300);

            Color color = new Color(numeroAleatorio.nextInt(256), numeroAleatorio.nextInt(256),
                    numeroAleatorio.nextInt(256));

            boolean flag = numeroAleatorio.nextBoolean();

            rectangulos[cuenta] = new MiRectangulo(x1, y1, x2, y2, color, flag);

            System.out.println(rectangulos[cuenta].toString());

        }

        cuenta++;

    }

    public static int getCuenta() {
        return cuenta;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (MiLinea linea : lineas) {
            linea.dibujar(g);
        }
        for (MiOvalo oval : ovalos) {
            oval.dibujar(g);
        }
        for (MiRectangulo rectan : rectangulos) {
            rectan.dibujar(g);
        }
    }

}
