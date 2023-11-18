package com.model.rj;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author rcarvajal@intelix.ad
 *
 * Clase doctor de ejemplo
 *
 */
public class Dorctor {
	
	private String name;
	
	private String lastName;
		
	private String speciality;
	
	private ArrayList<Appointment> appointments = new ArrayList<>();

	public Dorctor(String name, String lastName, String speciality) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.speciality = speciality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
	public void addAppointments(Appointment appointments) {
		this.appointments.add(appointments);
	}

	/**
	 * 
	 * @author rcarvajal@intelix.ad
	 * 
	 * Clase (cita) estatica anidada
	 *
	 */
	public static class Appointment{
		
		private String id;
		private Date date;
		private String hora;
		
		public Appointment(Date date, String hora) {
			super();
			this.date = date;
			this.hora = hora;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		@Override
		public String toString() {
			return "Appointment [date=" + date + ", hora=" + hora + "]";
		}		
	}	

}


