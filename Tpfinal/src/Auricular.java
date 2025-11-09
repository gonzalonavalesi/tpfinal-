public class Auricular extends Periferico{
    private String audio;
    private boolean microfono;

    public Auricular(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String audio, boolean microfono) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.audio = audio;
        this.microfono = microfono;
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
                "audio='" + audio + '\'' +
                ", microfono=" + microfono +
                "} " + super.toString();
    }
}
