public class Gabinete extends Producto{
    private boolean rgb;

    public Gabinete(boolean rgb,double precio, String marca, String modelo) {
        super(precio, marca, modelo);
        this.rgb=rgb;
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
}
