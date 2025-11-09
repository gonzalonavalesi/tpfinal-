public class Almacenamiento extends Producto{
    private TipoAlmacenamiento tipoAlmacenamiento;
    private int gb;

    public Almacenamiento(double precio, String marca, String modelo, TipoAlmacenamiento tipoAlmacenamiento, int gb) {
        super(precio, marca, modelo);
        this.tipoAlmacenamiento = tipoAlmacenamiento;
        this.gb = gb;
    }

    public TipoAlmacenamiento getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(TipoAlmacenamiento tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    @Override
    public String toString() {
        return "Almacenamiento{" +
                "tipoAlmacenamiento=" + tipoAlmacenamiento +
                ", gb=" + gb +
                "} " + super.toString();
    }
}
