package com.ricardo.dibuja_tiro_al_blanco;

import javax.swing.JFrame;

public class DibujarTiroAlBlanco {

    public static void main(String[] args) {

        PrepararDibujo dibujo = new PrepararDibujo();

        JFrame ventana = new JFrame("Tiro al blanco");

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(dibujo);

        ventana.setSize(230, 250);

        ventana.setVisible(true);

    }

}
