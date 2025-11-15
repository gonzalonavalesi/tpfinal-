package Clases;

import Enums.Certificacion;
import org.json.JSONObject;

public class Fuente extends Producto{
    //ATRIBUTOS
    private int watts;
    private Certificacion certificacion;

    //CONSTRUCTORES
    public Fuente(int stock,double precio, String marca, String modelo, int watts, Certificacion certificacion) {
        super(precio, marca, modelo,stock);
        this.watts = watts;
        this.certificacion = certificacion;
    }

    public Fuente(JSONObject obj){
        super(obj);
        this.watts = obj.getInt("watts");
        this.certificacion = Certificacion.valueOf(obj.getString("certificacion"));
    }

    //METODOS
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
        return "Clases.Fuente{" +
                super.toString()+
                "watts=" + watts +
                ", certificacion=" + certificacion +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Fuente");
        json.put("watts", this.watts);
        json.put("certificacion", this.certificacion.toString());
        return json;
    }
}
