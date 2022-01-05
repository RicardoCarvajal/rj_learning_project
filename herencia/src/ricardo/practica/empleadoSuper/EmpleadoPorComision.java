package ricardo.practica.empleadoSuper;

public class EmpleadoPorComision {

    private String primerNombre;

    private String apellidopaterno;

    private String numeroSeguroSocial;

    private double ventasBrutas;

    private double tarifasComision;

    public EmpleadoPorComision(String primerNombre, String apellidopaterno, String numeroSeguroSocial,
                               double ventasBrutas, double tarifasComision) {

        /* Llamada implisita del constructor del objeto 'Object' */
        this.primerNombre = primerNombre;
        this.apellidopaterno = apellidopaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifasComision = tarifasComision;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {

        if (ventasBrutas >= 0.0)
            this.ventasBrutas = ventasBrutas;
        else
            throw new IllegalArgumentException("Las ventas deben ser mallor a 0.0");
    }

    public double getTarifasComision() {
        return tarifasComision;
    }

    public void setTarifasComision(double tarifasComision) {
        if (tarifasComision > 0.0 && tarifasComision < 1.0)
            this.tarifasComision = tarifasComision;
        else
            throw new IllegalArgumentException("La tarifa por comision debe ser mayor que 0.0 y menor que 1.0");
    }

    public double ingresos() {
        return tarifasComision * ventasBrutas;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f", "Empleado por comision", primerNombre,
                             apellidopaterno, "Numero de seguro social", numeroSeguroSocial, "Ventas brutas",
                             ventasBrutas, "Tarifa de comision", tarifasComision);
    }

}
