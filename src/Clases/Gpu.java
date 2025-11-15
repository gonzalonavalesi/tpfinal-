package Clases;

import org.json.JSONObject;

public class Gpu extends Producto{
    //ATRIBUTOS
    private int memoria;

    //CONSTRUCORES
    public Gpu(int stock,double precio, String marca, String modelo, int memoria) {
        super(precio, marca, modelo,stock);
        this.memoria = memoria;
    }

    public Gpu(JSONObject obj){
        super(obj);
        this.memoria = obj.getInt("memoria");
    }

    //METODOS
    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "Clases.Gpu{" +
                super.toString()+
                "memoria=" + memoria +
                "} " +"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Gpu");
        json.put("memoria", this.memoria);
        return json;
    }
}
