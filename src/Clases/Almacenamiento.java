package Clases;

import Enums.TipoAlmacenamiento;
import org.json.JSONObject;

public class Almacenamiento extends Producto{
    //ATRIBUTOS
    private TipoAlmacenamiento tipoAlmacenamiento;
    private int gb;

    //CONSTRUCTOR
    public Almacenamiento(int stock, double precio, String marca, String modelo, TipoAlmacenamiento tipoAlmacenamiento, int gb) {
        super(precio, marca, modelo,stock);
        this.tipoAlmacenamiento = tipoAlmacenamiento;
        this.gb = gb;
    }

    //METODOS
    public Almacenamiento(JSONObject obj){
        super(obj);
        this.tipoAlmacenamiento = TipoAlmacenamiento.valueOf(obj.getString("tipoAlmacenamiento"));
        this.gb=obj.getInt("gb");
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
        return "Clases.Almacenamiento{" +
                super.toString()+
                "tipoAlmacenamiento=" + tipoAlmacenamiento +
                ", gb=" + gb +
                "} " +"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Almacenamiento");
        json.put("tipoAlmacenamiento", this.tipoAlmacenamiento.toString());
        json.put("gb", this.gb);
        return json;
    }
}
