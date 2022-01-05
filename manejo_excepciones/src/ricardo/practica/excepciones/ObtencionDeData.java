package ricardo.practica.excepciones;

public class ObtencionDeData {

    public static void main(String[] args) {

        try {
            metodo1();
        } catch (Exception exception) {
            System.err.printf("%s\n\n", exception.getMessage());
            exception.printStackTrace();

            StackTraceElement[] stackTraceElements = exception.getStackTrace();

            System.out.println("\n Restreo de la pila del metodo getStackTrace");
            System.out.println("Clase\t\t\t\t\t\tArchivo\t\t\tLinea\tMetodo");

            for (StackTraceElement element : stackTraceElements) {

                System.out.printf("%s\t", element.getClassName());
                System.out.printf("%s\t", element.getFileName());
                System.out.printf("%s\t", element.getLineNumber());
                System.out.printf("%s\n", element.getMethodName());

            }
        }

    }

    public static void metodo1() throws Exception {

        metodo2();

    }

    public static void metodo2() throws Exception {

        metodo3();

    }

    public static void metodo3() throws Exception {

        throw new Exception("Exepción del metodo 3");

    }

}
