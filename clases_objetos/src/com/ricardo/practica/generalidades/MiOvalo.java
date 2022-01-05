package com.ricardo.practica.generalidades;

import java.awt.Color;
import java.awt.Graphics;

public class MiOvalo {

    private int x1;

    private int y1;

    private int x2;

    private int y2;

    private Color miColor;

    private boolean flag;

    public MiOvalo(int x1, int y1, int x2, int y2, Color miColor, boolean flag) {
        super();
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        this.miColor = miColor;
        this.flag = flag;
    }

    public MiOvalo() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.miColor = Color.BLACK;
        this.flag = false;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {

        if (x1 >= 0) {
            this.x1 = x1;
        } else {
            this.x1 = 0;
            throw new IllegalArgumentException("Numero de coordenada x1 es menor que 0");
        }
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        if (y1 >= 0) {
            this.y1 = y1;
        } else {
            this.y1 = 0;
            throw new IllegalArgumentException("Numero de coordenada y1 es menor que 0");
        }
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        if (x2 >= 0) {
            this.x2 = x2;
        } else {
            this.x2 = 0;
            throw new IllegalArgumentException("Numero de coordenada x2 es menor que 0");
        }
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        if (y2 >= 0) {
            this.y2 = y2;
        } else {
            this.y2 = 0;
            throw new IllegalArgumentException("Numero de coordenada y2 es menor que 0");
        }
    }

    public Color getMiColor() {
        return miColor;
    }

    public void setMiColor(Color miColor) {
        this.miColor = miColor;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void dibujar(Graphics g) {
        g.setColor(miColor);
        if (flag == true)
            g.drawOval(getX1(), getY1(), getX2(), getY2());
        else
            g.fillOval(getX1(), getY1(), getX2(), getY2());

    }

    @Override
    public String toString() {
        return String.format("Ovalo\n X1 = %d y2 = %d X2 = %d y2 = %d", x1, y1, x2, y2);
    }

}
