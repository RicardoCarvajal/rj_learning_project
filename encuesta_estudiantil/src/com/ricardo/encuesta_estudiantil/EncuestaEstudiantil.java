package com.ricardo.encuesta_estudiantil;

public class EncuestaEstudiantil {

	public static void main(String[] args) {
		
		int[] respuestas = {1,2,2,2,3,4,2,2,3,5,5,1,2,5,5,1,1,1,1,15};
		
		int[] fercuencia = new int[6];
		
		for(int respuesta = 0;respuesta < respuestas.length; respuesta++){
			
			try{
				++fercuencia[respuestas[respuesta]];
				
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println(e);
				System.out.printf("		respuestas[%d] = %d \n\n", respuesta, respuestas[respuesta]);
			}
			
		}
		
		System.out.printf("%s %10s\n", "Respuesta","Frecuencia");
		
		for(int calificacion = 1; calificacion < fercuencia.length; calificacion++){
			System.out.printf("%6d %10d\n", calificacion, fercuencia[calificacion]);
		}

	}

}
