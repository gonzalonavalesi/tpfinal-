package Clases;

import org.json.JSONObject;

public class MousePad extends Periferico{
    //ATRIBUTOS
    private String tipoSuperficie;
    private String tamaño;

    //CONSTRUCTORES
    public MousePad(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String tipoSuperficie, String tamaño) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.tipoSuperficie = tipoSuperficie;
        this.tamaño = tamaño;
    }

    public MousePad(JSONObject obj){
        super(obj);
        this.tipoSuperficie = obj.getString("tipoSuperficie");
        this.tamaño = obj.getString("tamaño");
    }

    //METODOS
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
        return "Clases.MousePad{" +
                super.toString() +
                "tipoSuperficie='" + tipoSuperficie + '\'' +
                ", tamaño='" + tamaño + '\'' +
                "} "+"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.MousePad");
        json.put("tipoSuperficie", this.tipoSuperficie);
        json.put("tamaño", this.tamaño);
        return json;
    }
}
