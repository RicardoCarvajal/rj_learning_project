package ricardo.practica.clasespolimorficasinterface;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {

    private double salarioBase;

    public EmpleadoBaseMasComision(String nombre, String apellido, String seguroSocial, double ventasBrutas,
                                   double tarifaComision, double salarioBase) {
        super(nombre, apellido, seguroSocial, ventasBrutas, tarifaComision);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase > 0.0)
            this.salarioBase = salarioBase;
        else
            throw new IllegalArgumentException("El salario base debe ser mayor que 0");
    }

    @Override
    public double obtenerMontoPago() {
        return getSalarioBase() + super.obtenerMontoPago();
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f", "Con salario base", super.toString(), "Salario base",
                             getSalarioBase());
    }

}
