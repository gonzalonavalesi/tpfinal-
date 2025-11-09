public class MousePad extends Periferico{
    private String tipoSuperficie;
    private String tamaño;

    public MousePad(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String tipoSuperficie, String tamaño) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.tipoSuperficie = tipoSuperficie;
        this.tamaño = tamaño;
    }

    public String getTipoSuperficie() {
        return tipoSuperficie;
    }

    public void setTipoSuperficie(String tipoSuperficie) {
        this.tipoSuperficie = tipoSuperficie;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "MousePad{" +
                "tipoSuperficie='" + tipoSuperficie + '\'' +
                ", tamaño='" + tamaño + '\'' +
                "} " + super.toString();
    }
}
