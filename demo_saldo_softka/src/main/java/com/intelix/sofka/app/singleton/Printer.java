package com.intelix.sofka.app.singleton;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Printer {

	private boolean conn;
	private String line;

	private static Printer printer;

	public static Printer getInstance() {
		if (printer == null) {
			printer = new Printer();
		}
		return printer;
	}

	public Printer() {
		System.out.println("Activando conexion");
		this.conn = true;
	}

	public boolean getConn() {
		return conn;
	}

//	public void printTicket(String line) {
//		System.out.println(line);
//	}

}
