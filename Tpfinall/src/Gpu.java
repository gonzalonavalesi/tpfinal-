import org.json.JSONObject;

public class Gpu extends Producto{
    private int memoria;

    public Gpu(double precio, String marca, String modelo, int memoria) {
        super(precio, marca, modelo);
        this.memoria = memoria;
    }

    public Gpu(JSONObject obj){
        super(obj);
        this.memoria = obj.getInt("memoria");
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "Gpu{" +
                super.toString()+
                "memoria=" + memoria +
                "} " +"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Gpu");
        json.put("memoria", this.memoria);
        return json;
    }
}
