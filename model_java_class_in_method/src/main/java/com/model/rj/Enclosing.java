package com.model.rj;

/**
 * 
 * @author rcarvajal@intelix.ad
 * @Class
 * 
 *Clases anidadas dentro de un metodo
 *la clase padre es Enclosing y la clase dentro de su
 *metodo es run la cual tiene un metodo run
 *este tipo de clases no son muy usadas por temas de 
 *rendimiento
 *
 */
public class Enclosing {
	
	/**
	 * 
	 * @Method run()
	 * @Class
	 * 
	 * No recibe parametros, solo genera una instancia de
	 * la clase Local y ejecuta el metodo run de la clase Local
	 * 
	 */
	public void run() {
		/**
		 * 
		 * @author rcarvajal@intelix.ad
		 *
		 * @Class local 
		 * Clase anidada Local
		 *
		 */
		class Local{
			
			/**
			 * @Method run()
			 */
			void run() {
				System.out.println("Ejecutando clase anidada en metodo");
			}
		}
		
		Local local = new Local();
		local.run();
		
	}
	

	public static void main(String[] args) {
		Enclosing enclosing = new Enclosing();
		
		enclosing.run();
		
	}

}
