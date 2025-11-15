package Clases;

import org.json.JSONObject;
import Enums.Socket;

public class Cpu extends Producto{
    //ATRIBUTOS
    private Socket socket;
    private int nucleos;
    private int hilos;
    private String integrados;

    //CONSTRUCTORES
    public Cpu(int stock,double precio, String marca, String modelo, Socket socket, int nucleos, int hilos, String integrados) {
        super(precio, marca, modelo,stock);
        this.socket = socket;
        this.nucleos = nucleos;
        this.hilos = hilos;
        this.integrados = integrados;
    }

    public Cpu(JSONObject obj){
        super(obj);
        this.socket = Socket.valueOf(obj.getString("socket"));
        this.nucleos = obj.getInt("nucleos");
        this.hilos = obj.getInt("hilos");
        this.integrados = obj.getString("integrados");
    }

    //METODOS
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public int getHilos() {
        return hilos;
    }

    public void setHilos(int hilos) {
        this.hilos = hilos;
    }

    public String getIntegrados() {
        return integrados;
    }

    public void setIntegrados(String integrados) {
        this.integrados = integrados;
    }

    @Override
    public String toString() {
        return "Clases.Cpu{" +
                super.toString() +
                "socket=" + socket +
                ", nucleos=" + nucleos +
                ", hilos=" + hilos +
                ", integrados='" + integrados + '\'' +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Cpu");
        json.put("socket", this.socket.toString());
        json.put("nucleos", this.nucleos);
        json.put("hilos", this.hilos);
        json.put("integrados", this.integrados);
        return json;
    }
}
