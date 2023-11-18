package com.rj.practices.app;

public class Main {

	public static void main(String[] args) {

		Day day = Day.DOMINGO;

		switch (day) {
		case LUNES: {
			System.out.println("Hoy es " + Day.LUNES);
			break;
		}
		case MARTES: {
			System.out.println("Hoy es " + Day.MARTES);
			break;
		}
		case MIERCOLES: {
			System.out.println("Hoy es " + Day.MIERCOLES);
			break;
		}
		case JUEVES: {
			System.out.println("Hoy es " + Day.JUEVES);
			break;
		}
		case VIERNES: {
			System.out.println("Hoy es " + Day.VIERNES);
			break;
		}
		case SABADO: {
			System.out.println("Hoy es " + Day.SABADO);
			break;
		}
		case DOMINGO: {
			System.out.println("Hoy es " + Day.DOMINGO.getEnglish());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + day);
		}

	}

	public enum Day {
		LUNES("MONDAY"), MARTES("TUESDAY"), MIERCOLES("WEDNESDAY"), JUEVES("THURSDAY"), VIERNES("FRIDAY"),SABADO("SATURDAY"), DOMINGO("SUNDAY");

		private String english;
		
		Day(String english) {
			this.english  = english;
		}

		public String getEnglish() {
			return english;
		}		
		
		
	}

}
