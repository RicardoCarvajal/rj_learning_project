package ricardo.practica.clasespolimorficasabstrac;

public class PruebaSistemaEmpleado {

    public static void main(String[] args) {

        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Jose", "Martines", "16775963", 14000);

        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Ricardo", "Caravjal", "167724392", 5000, 8);

        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Emily", "Reina", "21032652", 8000, 0.1);

        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Alvaro", "Fariaz",
                "8563265", 5000, 0.1, 5000);

        System.out.println("Empleado por separados: \n");

        System.out.printf("%s \n%s: $%,.2f\n\n", empleadoAsalariado, "Ingresos", empleadoAsalariado.ingresos());

        System.out.printf("%s \n%s: $%,.2f\n\n", empleadoPorHoras, "Ingresos", empleadoPorHoras.ingresos());

        System.out.printf("%s \n%s: $%,.2f\n\n", empleadoPorComision, "Ingresos", empleadoPorComision.ingresos());

        System.out.printf("%s \n%s: $%,.2f\n\n", empleadoBaseMasComision, "Ingresos",
                          empleadoBaseMasComision.ingresos());

        Empleado[] empleados = new Empleado[4];

        empleados[0] = empleadoAsalariado;
        empleados[1] = empleadoPorHoras;
        empleados[2] = empleadoPorComision;
        empleados[3] = empleadoBaseMasComision;

        System.out.println("Empleado procesados de forma polimorfica: \n");

        for (Empleado empleadoActual : empleados) {

            System.out.println(empleadoActual);

            if (empleadoActual instanceof EmpleadoBaseMasComision) {

                EmpleadoBaseMasComision empleadoBaseMasComisionActual = (EmpleadoBaseMasComision) empleadoActual;

                empleadoBaseMasComisionActual
                        .setSalarioBase(1.10 * empleadoBaseMasComisionActual.getSalarioBase());

                System.out.printf("El nuevo salario base con 10%% de aumento es : $%,.2f\n",
                                  empleadoBaseMasComisionActual.getSalarioBase());
            }

            System.out.printf("Ingresos $%,.2f\n\n", empleadoActual.ingresos());

        }

        for (int i = 0; i < empleados.length; i++) {
            System.out.printf("El empleado %d es un %s\n", i, empleados[i].getClass().getName());
        }

    }

}
