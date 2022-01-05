package ricardo.practica.clasespolimorficasinterface;

public class Factura implements PorPagar {

    private String numeroPiezas;

    private String descripcionPieza;

    private int cantidad;

    private double precioPorArticulo;

    public Factura(String numeroPiezas, String descripcionPieza, int cantidad, double precioPorArticulo) {
        super();
        this.numeroPiezas = numeroPiezas;
        this.descripcionPieza = descripcionPieza;
        this.cantidad = cantidad;
        this.precioPorArticulo = precioPorArticulo;
    }

    public String getNumeroPiezas() {
        return numeroPiezas;
    }

    public void setNumeroPiezas(String numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0)
            this.cantidad = cantidad;
        else
            throw new IllegalArgumentException("cantidad debe ser >= 0");
    }

    public double getPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void setPrecioPorArticulo(double precioPorArticulo) {
        if (precioPorArticulo >= 0.0)
            this.precioPorArticulo = precioPorArticulo;
        else
            throw new IllegalArgumentException("El precio debe ser >= 0");
    }

    @Override
    public String toString() {
        return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", "factura", "Numero de piezas",
                             getNumeroPiezas(), getDescripcionPieza(), "Cantidad", getCantidad(),
                             "Precio por articulo", getPrecioPorArticulo());
    }

    @Override
    public double obtenerMontoPago() {

        return getCantidad() * getPrecioPorArticulo();

    }

}
