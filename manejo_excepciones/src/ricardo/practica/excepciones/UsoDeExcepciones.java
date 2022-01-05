package ricardo.practica.excepciones;

public class UsoDeExcepciones {

    public static void main(String[] args) {

        try {
            lanzaExcepcion();
        } catch (Exception exception) {
            System.err.println("La excepcion de lanzaEcepcion se manejo en el main");
        }

        noLanzaExcepcion();

    }

    public static void lanzaExcepcion() throws Exception {
        try {
            System.out.println("Metodo lanza excepcion");
            throw new Exception();
        } catch (Exception exception) {
            System.err.println("La excepcion se manejo en el metodo lanzaExcepcion");
            throw exception;
        } finally {
            System.err.println("Se ejecuto finally en lanzaExcepcion");
        }
    }

    public static void noLanzaExcepcion() {
        try {
            System.out.println("Metodo noLanzaExcepcion");
        } catch (Exception exception) {
            System.err.println(exception);
        } finally {
            System.err.println("Se ejecuto finally en noLanzaExcepcion");
        }

        System.out.println("Fin del metodo noLanzaExcepcion");
    }

}
