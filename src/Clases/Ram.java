package Clases;

import Enums.TipoMemoria;
import org.json.JSONObject;

public class Ram extends Producto{
    //ATRIBUTOS
    private TipoMemoria tipoMemoria;
    private int gb;

    //CONSTRUCTORES
    public Ram(int stock,double precio, String marca, String modelo, TipoMemoria tipoMemoria, int gb) {
        super(precio, marca, modelo,stock);
        this.tipoMemoria = tipoMemoria;
        this.gb = gb;
    }

    public Ram(JSONObject obj){
        super(obj);
        this.tipoMemoria = TipoMemoria.valueOf(obj.getString("tipoMemoria"));
        this.gb = obj.getInt("gb");
    }

    //MERTODOS
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
        return "Clases.Ram{" +
                super.toString()+
                "tipoMemoria=" + tipoMemoria +
                ", gb=" + gb +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Ram");
        json.put("tipoMemoria", this.tipoMemoria.toString());
        json.put("gb", this.gb);
        return json;
    }
}
