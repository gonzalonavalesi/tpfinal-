package Clases;

import org.json.JSONObject;

public class Gabinete extends Producto{
    //ATRIBUTOS
    private boolean rgb;

    //CONSTRUCTORES
    public Gabinete(boolean rgb,double precio, String marca, String modelo) {
        super(precio, marca, modelo);
        this.rgb=rgb;
    }

    public Gabinete(JSONObject obj){
        super(obj);
        this.rgb = obj.getBoolean("rgb");
    }

    //METODOS
    public boolean isRgb() {
        return rgb;
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "Clases.Gabinete{" +
                super.toString()+
                "rgb=" + rgb +
                "} " +"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Gabinete");
        json.put("rgb", this.rgb);
        return json;
    }
}
