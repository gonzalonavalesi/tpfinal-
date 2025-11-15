package Clases;

import Enums.Socket;
import Enums.TipoRefrigeracion;
import org.json.JSONObject;

public class Refrigeracion extends Producto{
    //ATRIBUTOS
    private Socket socket;
    private TipoRefrigeracion refrigeracion;

    //CONSTRUCTORES
    public Refrigeracion(int stock,double precio, String marca, String modelo, Socket socket, TipoRefrigeracion refrigeracion) {
        super(precio, marca, modelo,stock);
        this.socket = socket;
        this.refrigeracion = refrigeracion;
    }

    public Refrigeracion(JSONObject obj){
        super(obj);
        this.socket = Socket.valueOf(obj.getString("socket"));
        this.refrigeracion = TipoRefrigeracion.valueOf(obj.getString("refrigeracion"));
    }

    //METODOS
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public TipoRefrigeracion getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(TipoRefrigeracion refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    @Override
    public String toString() {
        return "Clases.Refrigeracion{" +
                super.toString()+
                "socket=" + socket +
                ", refrigeracion=" + refrigeracion +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Refrigeracion");
        json.put("socket", this.socket.toString());
        json.put("refrigeracion", this.refrigeracion.toString());
        return json;
    }
}
