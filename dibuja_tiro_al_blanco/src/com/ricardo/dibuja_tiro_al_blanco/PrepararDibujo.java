package com.ricardo.dibuja_tiro_al_blanco;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class PrepararDibujo extends JPanel {

    private int r;

    private int g;

    private int b;

    private Random numeroAleatorio = new Random();

    public void paintComponent(Graphics ga) {

        pintarColores();

        super.paintComponent(ga);

        ga.setColor(new Color(r, g, b));
        ga.fillOval(10, 10, 200, 200);

        pintarColores();

        ga.setColor(new Color(r, g, b));
        ga.fillOval(25, 25, 170, 170);

        pintarColores();

        ga.setColor(new Color(r, g, b));
        ga.fillOval(40, 40, 140, 140);

        pintarColores();

        ga.setColor(new Color(r, g, b));
        ga.fillOval(55, 55, 110, 110);

        pintarColores();

        ga.setColor(new Color(r, g, b));
        ga.fillOval(75, 75, 70, 70);

        pintarColores();

        ga.setColor(new Color(r, g, b));
        ga.fillOval(95, 95, 30, 30);

    }

    public void pintarColores() {

        r = numeroAleatorio.nextInt(255);

        g = numeroAleatorio.nextInt(255);

        b = numeroAleatorio.nextInt(255);

    }

}
