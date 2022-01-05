package ricardo.practica.paquetesub;

import ricardo.practica.paquetesuper.SuperClase;

public class SubClase extends SuperClase {

    /*
     * Heredando el metodo de la clase desde una subclase fuera del paquete de la super
     * clase
     */
    @Override
    protected Integer getNumeroAleatoreo() {
        return super.getNumeroAleatoreo();
    }

    public static void main(String[] args) {

        SubClase obtener = new SubClase();

        Integer numero1 = obtener.getNumeroAleatoreo();

        String texto = String.format("El numero aleatorio desde el metodo heredado es: %d", numero1);

        System.out.println(texto);

    }

}
