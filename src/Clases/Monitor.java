package Clases;

import org.json.JSONObject;

public class Monitor extends Periferico{
    //ATRIBUTOS
    private double pulgadas;
    private String calidadPantalla;
    private boolean curvo;
    private int frecuencia;
    private int tiempoRespuesta;

    //CONSTRUCTORES
    public Monitor(int stock,double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, double pulgadas, String calidadPantalla, boolean curvo, int frecuencia, int tiempoRespuesta) {
        super(stock,precio, marca, modelo, color, rgb, inalambrico);
        this.pulgadas = pulgadas;
        this.calidadPantalla = calidadPantalla;
        this.curvo = curvo;
        this.frecuencia = frecuencia;
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public Monitor(JSONObject obj){
        super(obj);
        this.pulgadas = obj.getDouble("pulgadas");
        this.calidadPantalla = obj.getString("calidadPantalla");
        this.curvo = obj.getBoolean("curvo");
        this.frecuencia = obj.getInt("frecuencia");
        this.tiempoRespuesta = obj.getInt("tiempoRespuesta");
    }

    //METODOS
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
        return "Clases.Monitor{" +
                super.toString()+
                "pulgadas=" + pulgadas +
                ", calidadPantalla='" + calidadPantalla + '\'' +
                ", curvo=" + curvo +
                ", frecuencia=" + frecuencia +
                ", tiempoRespuesta=" + tiempoRespuesta +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Monitor");
        json.put("pulgadas", this.pulgadas);
        json.put("calidadPantalla", this.calidadPantalla);
        json.put("curvo", this.curvo);
        json.put("frecuencia", this.frecuencia);
        json.put("tiempoRespuesta", this.tiempoRespuesta);
        return json;
    }
}
