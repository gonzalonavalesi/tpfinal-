package Clases;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mouse extends Periferico{
    //ATRIBUTOIS
    private ArrayList<Integer>dpi;

    //CONSTRUCTORES
    public Mouse(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, ArrayList<Integer> dpi) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.dpi = dpi;
    }

    public Mouse(JSONObject obj){
        super(obj);
        this.dpi = new ArrayList<>();
        JSONArray dpiArray = obj.getJSONArray("dpi");
        for(int i = 0; i < dpiArray.length(); i++){
            this.dpi.add(dpiArray.getInt(i));
        }
    }

    //METODOS
    public void agregarDpi(int dpii){
        dpi.add(dpii);
    }

    @Override
    public String toString() {
        return "Clases.Mouse{" +
                super.toString()+
                "dpi=" + dpi +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Mouse");
        JSONArray dpiArray = new JSONArray();
        for(Integer dpiValue : this.dpi){
            dpiArray.put(dpiValue);
        }
        json.put("dpi", dpiArray);
        return json;
    }
}
