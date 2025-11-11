import org.json.JSONObject;

public class Gabinete extends Producto{
    private boolean rgb;

    public Gabinete(boolean rgb,double precio, String marca, String modelo) {
        super(precio, marca, modelo);
        this.rgb=rgb;
    }

    public Gabinete(JSONObject obj){
        super(obj);
        this.rgb = obj.getBoolean("rgb");
    }

    public boolean isRgb() {
        return rgb;
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "Gabinete{" +
                super.toString()+
                "rgb=" + rgb +
                "} " +"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Gabinete");
        json.put("rgb", this.rgb);
        return json;
    }
}
