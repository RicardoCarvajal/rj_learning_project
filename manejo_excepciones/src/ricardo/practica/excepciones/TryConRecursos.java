package ricardo.practica.excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryConRecursos {

    public static void main(String[] args) {

        // Funcion a partir de java 7
        try (BufferedReader archivo = new BufferedReader(
                new FileReader("../Documentos/Changelogs y Despliegue/ChangeLogs temporales/tmp_.md"))) {

            String linea;

            while ((linea = archivo.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
