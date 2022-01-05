package ricardo.practica.excepciones;

import java.util.Scanner;

public class PruebaAssert {

    // Para que funcione se debe configurar el rum con los parametros -ea

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero de 0 a 10:\n");

        int numero = scanner.nextInt();

        assert (numero >= 0 && numero <= 10) : "numero incorrecto: " + numero;

        System.out.printf("Usted escribio %d\n", numero);

        scanner.close();

    }

}
