package ricardo.practica.clasespolimorficasinterface;

public class PruebaSistemaEmpleado {

    public static void main(String[] args) {

        PorPagar[] objetosPorPagar = new PorPagar[4];

        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("50554", "llanta", 4, 1563.00);
        objetosPorPagar[2] = new EmpleadoAsalariado("Ricardo", "Carvajal", "17772459", 5000000.00);
        objetosPorPagar[3] = new EmpleadoAsalariado("Emily", "Reina", "21032678", 5000000.00);

        System.out.println("Factura y empleados procesados de manera polimorfica\n");

        for (PorPagar actual : objetosPorPagar) {

            System.out.printf("%s \n%s: $%,.2f\n\n", actual.toString(), "Pago vencido", actual.obtenerMontoPago());

        }

    }

}
