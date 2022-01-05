package ricardo.practica.empleadoSuper;

public class EmpleadoBaseMasComision extends EmpleadoPorComision implements Cloneable {

    private double salarioBase;

    public EmpleadoBaseMasComision(String primerNombre, String apellidopaterno, String numeroSeguroSocial,
                                   double ventasBrutas, double tarifasComision, double salarioBase) {
        super(primerNombre, apellidopaterno, numeroSeguroSocial, ventasBrutas, tarifasComision);

        setSalarioBase(salarioBase);

    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0.0)
            this.salarioBase = salarioBase;
        else
            throw new IllegalArgumentException("El salario base debe ser mayor igual que cero");
    }

    @Override
    public double ingresos() {
        return getSalarioBase() + super.ingresos();
    }

    @Override
    public String toString() {
        return String.format("%s %s\n%s: %.2f", "Con sueldo base", super.toString(), "Salario base", salarioBase);

    }

    public Object clone() {

        EmpleadoBaseMasComision obj = null;
        try {
            obj = (EmpleadoBaseMasComision) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("No se pudo copiar el objeto");
        }
        return obj;
    }

}
