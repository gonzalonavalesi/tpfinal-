import org.json.JSONObject;

public abstract class Periferico extends Producto{
    private String color;
    private boolean rgb;
    private boolean inalambrico;

    public Periferico(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico) {
        super(precio, marca, modelo);
        this.color = color;
        this.rgb = rgb;
        this.inalambrico = inalambrico;
    }

    public Periferico(JSONObject obj){
        super(obj);
        this.color = obj.getString("color");
        this.rgb = obj.getBoolean("rgb");
        this.inalambrico = obj.getBoolean("inalambrico");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRgb() {
        return rgb;
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
    }

    public boolean isInalambrico() {
        return inalambrico;
    }

    public void setInalambrico(boolean inalambrico) {
        this.inalambrico = inalambrico;
    }

    @Override
    public String toString() {
        return "Periferico{" +
                super.toString() +
                "color='" + color + '\'' +
                ", rgb=" + rgb +
                ", inalambrico=" + inalambrico +
                "} ";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("color", this.color);
        json.put("rgb", this.rgb);
        json.put("inalambrico", this.inalambrico);
        return json;
    }
}
