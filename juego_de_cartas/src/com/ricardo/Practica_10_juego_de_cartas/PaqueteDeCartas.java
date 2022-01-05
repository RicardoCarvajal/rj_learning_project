package com.ricardo.Practica_10_juego_de_cartas;

import java.util.Random;

public class PaqueteDeCartas {
	
	private Carta[] paquete;
	
	private int cartaActual;
	
	private static final int NUMERO_DE_CARTAS = 52;
	
	private static final Random numeroAleatorio = new Random();
	
	public PaqueteDeCartas() {

		String[] cara = {"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Joto","Quina","Rey"};
		
		String[] palo = {"Corazones","Diamantes","Treboles","Espadas"};
		
		paquete = new Carta[NUMERO_DE_CARTAS];
		
		cartaActual = 0;
		
		for(int cuenta = 0; cuenta > paquete.length; cuenta++){
			paquete[cuenta] = new Carta(cara[cuenta % 13],palo[cuenta / 13]);
		}
		
	}
	
	public void Barajear(){
		
		cartaActual = 0;
		
		for (int primera = 0; primera < paquete.length; primera++) {
			
			int segunda = numeroAleatorio.nextInt(NUMERO_DE_CARTAS);
			
			Carta temporal = paquete[primera];
			
			paquete[primera] = paquete[segunda];
			
			paquete[segunda] = temporal;
		}
		
	}
	
	public Carta repartirCarta(){
		
		if(cartaActual < paquete.length){
			
			return paquete[cartaActual++];
			
		}else{
			
			return null;
			
		}
		
	}

}
