public class Ram extends Producto{
    private TipoMemoria tipoMemoria;
    private int gb;

    public Ram(double precio, String marca, String modelo, TipoMemoria tipoMemoria, int gb) {
        super(precio, marca, modelo);
        this.tipoMemoria = tipoMemoria;
        this.gb = gb;
    }

    public TipoMemoria getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(TipoMemoria tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    @Override
    public String toString() {
        return "Ram{" +
                super.toString()+
                "tipoMemoria=" + tipoMemoria +
                ", gb=" + gb +
                "} " + "\n\n";
    }
}
