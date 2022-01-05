package com.ricardo.practica.generalidades;

import static com.ricardo.practica.generalidades.PanelDibujo.getCuenta;

import javax.swing.JFrame;

public class GeneralidadesClasesObjetos {

    public static void main(String[] args) {

        PanelDibujo panel1 = new PanelDibujo();

        PanelDibujo panel2 = new PanelDibujo();

        JFrame aplicacion1 = new JFrame("Aplicacion de Practica");

        JFrame aplicacion2 = new JFrame("Aplicacion de Practica");

        aplicacion1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aplicacion1.add(panel1);

        aplicacion1.setSize(600, 600);

        aplicacion1.setVisible(true);

        aplicacion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aplicacion2.add(panel2);

        aplicacion2.setSize(600, 600);

        aplicacion2.setVisible(true);

        System.out.println(getCuenta());

    }

}
