import org.json.JSONObject;

public class Auricular extends Periferico{
    private String audio;
    private boolean microfono;

    public Auricular(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String audio, boolean microfono) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.audio = audio;
        this.microfono = microfono;
    }


    public Auricular(JSONObject obj){
        super(obj);
        this.audio = obj.getString("audio");
        this.microfono = obj.getBoolean("microfono");
    }

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
        return "Auricular{" +
                super.toString()+
                "audio='" + audio + '\'' +
                ", microfono=" + microfono +
                "} " + "\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "Auricular");
        json.put("audio", this.audio);
        json.put("microfono", this.microfono);
        return json;
    }
}
