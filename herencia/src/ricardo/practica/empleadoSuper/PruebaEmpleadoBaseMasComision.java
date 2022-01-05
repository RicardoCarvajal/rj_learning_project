package ricardo.practica.empleadoSuper;

public class PruebaEmpleadoBaseMasComision {

    public static void modificaEmpleado(EmpleadoBaseMasComision empleado) {

        empleado.setVentasBrutas(500);

        empleado.setTarifasComision(.1);

        System.out.printf("\n%s : \n\n%s\n",
                          "Informacion actualizada del empleado, obtenida mediante toString implicito", empleado);

    }

    public static void main(String[] args) {

        EmpleadoBaseMasComision empleadoPorComision = new EmpleadoBaseMasComision("Ricardo", "Carvajal",
                "16772439", 100000, .06, 150000);

        System.out.println("Informacion del empleado por los metodos set");

        System.out.printf("%s %s\n", "El primer nombre es: ", empleadoPorComision.getPrimerNombre());

        System.out.printf("%s %s\n", "El apellido paterno es: ", empleadoPorComision.getApellidopaterno());

        System.out.printf("%s %s\n", "El numero de seguro social es: ",
                          empleadoPorComision.getNumeroSeguroSocial());

        System.out.printf("%s %s\n", "El monto de las ventas brutas es: ", empleadoPorComision.getVentasBrutas());

        System.out.printf("%s %s\n", "El monto de la tarifa de comision es: ",
                          empleadoPorComision.getTarifasComision());

        System.out.printf("%s %s\n", "El monto del sueldo base es: ", empleadoPorComision.getSalarioBase());

        modificaEmpleado((EmpleadoBaseMasComision) empleadoPorComision.clone());

        System.out.printf("\n%s : \n\n%s\n",
                          "Informacion actualizada del empleado, obtenida mediante toString implicito",
                          empleadoPorComision);

    }

}
