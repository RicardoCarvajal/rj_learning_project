package ricardo.practica.clasespolimorficasabstrac;

public class EmpleadoPorComision extends Empleado {

    private double ventasBrutas;

    private double tarifaComision;

    public EmpleadoPorComision(String nombre, String apellido, String seguroSocial, double ventasBrutas,
                               double tarifaComision) {
        super(nombre, apellido, seguroSocial);
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        if (ventasBrutas > 0.0)
            this.ventasBrutas = ventasBrutas;
        else
            throw new IllegalArgumentException("Las ventas brutas deben ser mayor que 0.0");
    }

    public double getTarifaComision() {
        return tarifaComision;
    }

    public void setTarifaComision(double tarifaComision) {
        if ((tarifaComision > 0.0) && (tarifaComision < 1.0))
            this.tarifaComision = tarifaComision;
        else
            throw new IllegalArgumentException("La tarifa por comision debe ser > 0.0 y < 1.0");
    }

    @Override
    public double ingresos() {
        return getTarifaComision() * getVentasBrutas();
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: $%,.2f; %s: %.2f", "Empleado por comision", super.toString(),
                             "Ventas brutas", getVentasBrutas(), "Tarifa por comision", getTarifaComision());
    }

}
