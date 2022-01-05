package ricardo.practica.clasespolimorficasabstrac;

public class EmpleadoPorHoras extends Empleado {

    private double sueldo;

    private double horas;

    public EmpleadoPorHoras(String nombre, String apellido, String seguroSocial, double sueldo, double horas) {
        super(nombre, apellido, seguroSocial);
        this.sueldo = sueldo;
        this.horas = horas;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo > 0.0)
            this.sueldo = sueldo;
        else
            throw new IllegalArgumentException("El sueldo debe ser mayor que 0");
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        if ((horas >= 0.0) && (horas <= 168.0))
            this.horas = horas;
        else
            throw new IllegalArgumentException("Las horas trabajadas deben ser  > = 0.0 y < = 168.0");
    }

    @Override
    public double ingresos() {
        if (getHoras() <= 40)
            return getSueldo() * getHoras();
        else
            return 40 * getSueldo() + (getHoras() - 40) * getSueldo() * 1.5;
    }

    @Override
    public String toString() {
        return String.format("Empleado por horas: %s \n%s: $%,.2f; %s: %,.2f", super.toString(), "Sueldo por hora",
                             getSueldo(), "Horas trabajadas:", getHoras());
    }

}
