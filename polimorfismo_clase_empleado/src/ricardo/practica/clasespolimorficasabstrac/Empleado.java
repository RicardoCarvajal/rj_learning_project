package ricardo.practica.clasespolimorficasabstrac;

public abstract class Empleado {

    private String nombre;

    private String apellido;

    private String seguroSocial;

    public Empleado(String nombre, String apellido, String seguroSocial) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.seguroSocial = seguroSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSeguroSocial() {
        return seguroSocial;
    }

    public void setSeguroSocial(String seguroSocial) {
        this.seguroSocial = seguroSocial;
    }

    @Override
    public String toString() {
        return String.format("%s %s\nNumero de seguro social: %s", getNombre(), getApellido(), getSeguroSocial());
    }

    public abstract double ingresos();

}
