package ricardo.practica.clasespolimorficasinterface;

public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    public EmpleadoAsalariado(String nombre, String apellido, String seguroSocial, double salarioSemanal) {
        super(nombre, apellido, seguroSocial);
        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        if (salarioSemanal > 0)
            this.salarioSemanal = salarioSemanal;
        else
            throw new IllegalArgumentException("El salario debe ser mayo que 0");
    }

    @Override
    public String toString() {
        return String.format("Empleado asalariado: %s \n%s: $%,.2f", super.toString(), "Salario semanal:",
                             getSalarioSemanal());
    }

    @Override
    public double obtenerMontoPago() {
        return getSalarioSemanal();
    }

}
