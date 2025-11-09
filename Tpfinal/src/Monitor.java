public class Monitor extends Periferico{
    private double pulgadas;
    private String calidadPantalla;
    private boolean curvo;
    private int frecuencia;
    private int tiempoRespuesta;

    public Monitor(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, double pulgadas, String calidadPantalla, boolean curvo, int frecuencia, int tiempoRespuesta) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.pulgadas = pulgadas;
        this.calidadPantalla = calidadPantalla;
        this.curvo = curvo;
        this.frecuencia = frecuencia;
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getCalidadPantalla() {
        return calidadPantalla;
    }

    public void setCalidadPantalla(String calidadPantalla) {
        this.calidadPantalla = calidadPantalla;
    }

    public boolean isCurvo() {
        return curvo;
    }

    public void setCurvo(boolean curvo) {
        this.curvo = curvo;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "pulgadas=" + pulgadas +
                ", calidadPantalla='" + calidadPantalla + '\'' +
                ", curvo=" + curvo +
                ", frecuencia=" + frecuencia +
                ", tiempoRespuesta=" + tiempoRespuesta +
                "} " + super.toString();
    }
}
