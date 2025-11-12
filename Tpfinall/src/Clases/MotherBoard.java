package Clases;

import Enums.Socket;
import org.json.JSONObject;

public class MotherBoard extends Producto{
    //ATRIBUTOS
    private Socket socket;

    //CONSTRUCTORES
    public MotherBoard(double precio, String marca, String modelo, Socket socket) {
        super(precio, marca, modelo);
        this.socket = socket;
    }

    public MotherBoard(JSONObject obj){
        super(obj);
        this.socket = Socket.valueOf(obj.getString("socket"));
    }

//METODOS
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Clases.MotherBoard{" +
                super.toString()+
                "socket=" + socket +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.MotherBoard");
        json.put("socket", this.socket.toString());
        return json;
    }
}
