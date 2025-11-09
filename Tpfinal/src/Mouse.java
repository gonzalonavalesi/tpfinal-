import java.util.ArrayList;

public class Mouse extends Periferico{
    private ArrayList<Integer>dpi;

    public Mouse(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, ArrayList<Integer> dpi) {
        super(precio, marca, modelo, color, rgb, inalambrico);
        this.dpi = dpi;
    }

    public void agregarDpi(int dpii){
        dpi.add(dpii);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "dpi=" + dpi +
                "} " + super.toString();
    }
}
