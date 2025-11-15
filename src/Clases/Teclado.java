package Clases;

import Enums.TipoMecanismo;
import Enums.TipoTeclado;
import org.json.JSONObject;

public class Teclado extends Periferico{
    //ATRIBUTOS
    private TipoTeclado tipoTeclado;
    private TipoMecanismo tipoMecanismo;

    //CONSTRUCTORES
    public Teclado(int stock,double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, TipoTeclado tipoTeclado, TipoMecanismo tipoMecanismo) {
        super(stock,precio, marca, modelo, color, rgb, inalambrico);
        this.tipoTeclado = tipoTeclado;
        this.tipoMecanismo = tipoMecanismo;
    }

    //METODOS
    public Teclado(JSONObject obj){
        super(obj);
        this.tipoTeclado = TipoTeclado.valueOf(obj.getString("tipoTeclado"));
        this.tipoMecanismo = TipoMecanismo.valueOf(obj.getString("tipoMecanismo"));
    }

    public TipoTeclado getTipoTeclado() {
        return tipoTeclado;
    }

    public void setTipoTeclado(TipoTeclado tipoTeclado) {
        this.tipoTeclado = tipoTeclado;
    }

    public TipoMecanismo getTipoMecanismo() {
        return tipoMecanismo;
    }

    public void setTipoMecanismo(TipoMecanismo tipoMecanismo) {
        this.tipoMecanismo = tipoMecanismo;
    }

    @Override
    public String toString() {
        return "Clases.Teclado{" +
                super.toString()+
                "tipoTeclado=" + tipoTeclado +
                ", tipoMecanismo=" + tipoMecanismo +
                "} " + "\n\n";
    }

    // Clases.Teclado.java
    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Teclado");
        json.put("tipoTeclado", this.tipoTeclado.toString());
        json.put("tipoMecanismo", this.tipoMecanismo.toString());
        return json;
    }
}
