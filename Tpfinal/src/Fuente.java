public class Fuente extends Producto{
    private int watts;
    private Certificacion certificacion;

    public Fuente(double precio, String marca, String modelo, int watts, Certificacion certificacion) {
        super(precio, marca, modelo);
        this.watts = watts;
        this.certificacion = certificacion;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    @Override
    public String toString() {
        return "Fuente{" +
                "watts=" + watts +
                ", certificacion=" + certificacion +
                "} " + super.toString();
    }
}
