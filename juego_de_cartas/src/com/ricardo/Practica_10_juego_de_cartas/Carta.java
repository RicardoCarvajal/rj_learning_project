package com.ricardo.Practica_10_juego_de_cartas;

public class Carta {
	
	private String cara;
	
	private String palo;

	public Carta(String cara, String palo) {
		this.cara = cara;
		this.palo = palo;
	}
	
	public String toString(){
		return cara + " de " + palo;
	}

}
