package Clases;

import org.json.JSONObject;

public class Auricular extends Periferico{
    //ATRIBUTOS
    private String audio;
    private boolean microfono;

    //CONSTRUCTOR
    public Auricular(int stock,double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String audio, boolean microfono) {
        super(stock,precio, marca, modelo, color, rgb, inalambrico);
        this.audio = audio;
        this.microfono = microfono;
    }


    public Auricular(JSONObject obj){
        super(obj);
        this.audio = obj.getString("audio");
        this.microfono = obj.getBoolean("microfono");
    }

    //METODOS
    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public boolean isMicrofono() {
        return microfono;
    }

    public void setMicrofono(boolean microfono) {
        this.microfono = microfono;
    }


    @Override
    public String toString() {
        return "Clases.Auricular{" +
                super.toString()+
                "audio='" + audio + '\'' +
                ", microfono=" + microfono +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Clases.Auricular");
        json.put("audio", this.audio);
        json.put("microfono", this.microfono);
        return json;
    }
}
