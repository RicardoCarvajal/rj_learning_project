package com.model.rj;

import java.util.Date;

/**
 * 
 * @author rcarvajal@intelix.ad
 *
 */
public class Main {

	public static void main(String[] args) {
		Dorctor doctor = new Dorctor("Ricardo", "Carvajal", "Internista");
		
		/**
		 * Siendo Appointment una clase estatica podemos usarla de la siguiente manera
		 * new Dorctor.Appointment(Date, String)
		 * 
		 * Si nos fijamos en los imports la clase Appointment no genera una instancia 
		 * dentro de esta clase main, ya que es estatica.
		 */
		doctor.addAppointments(new Dorctor.Appointment(new Date(), "07:00 AM"));
		doctor.addAppointments(new Dorctor.Appointment(new Date(), "08:00 AM"));
		doctor.addAppointments(new Dorctor.Appointment(new Date(), "09:00 AM"));
		doctor.addAppointments(new Dorctor.Appointment(new Date(), "10:30 AM"));
		
		System.out.println("Citas doctor: " + doctor.getName() + " "+ doctor.getLastName()  + "\n");		
		doctor.getAppointments().forEach(a -> System.out.println(a.toString()));
		

	}

}
