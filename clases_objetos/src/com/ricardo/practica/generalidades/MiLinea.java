package com.ricardo.practica.generalidades;

import java.awt.Color;
import java.awt.Graphics;

public class MiLinea {

    private int x1;

    private int y1;

    private int x2;

    private int y2;

    private Color miColor;

    public MiLinea(int x1, int y1, int x2, int y2, Color miColor) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.miColor = miColor;
    }

    public void dibujar(Graphics g) {
        g.setColor(miColor);
        g.drawLine(x1, y1, x2, y2);

    }

}
