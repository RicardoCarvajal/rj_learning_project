package ricardo.practica.paquetesuper;

public class ClaseImplementaMetodos {

    public static void main(String[] args) {

        SuperClase obtener = new SuperClase();

        Integer numero1 = obtener.getNumeroAleatoreo();

        Integer numero2 = obtener.numeroAleatoreo.nextInt(10);

        /* Se usa el metodo dentro de una clase del mismo paquete */
        String texto = String.format("El numero aleatorio desde el metodo es: %d, y desde el campo es: %d",
                                     numero1, numero2);

        System.out.println(texto);

    }

}
