public class Teclado extends Periferico{
    private TipoTeclado tipoTeclado;
    private TipoMecanismo tipoMecanismo;

    public Teclado(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, TipoTeclado tipoTeclado, TipoMecanismo tipoMecanismo) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.tipoTeclado = tipoTeclado;
        this.tipoMecanismo = tipoMecanismo;
    }

    public TipoTeclado getTipoTeclado() {
        return tipoTeclado;
    }

    public void setTipoTeclado(TipoTeclado tipoTeclado) {
        this.tipoTeclado = tipoTeclado;
    }

    public TipoMecanismo getTipoMecanismo() {
        return tipoMecanismo;
    }

    public void setTipoMecanismo(TipoMecanismo tipoMecanismo) {
        this.tipoMecanismo = tipoMecanismo;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "tipoTeclado=" + tipoTeclado +
                ", tipoMecanismo=" + tipoMecanismo +
                "} " + super.toString();
    }
}
