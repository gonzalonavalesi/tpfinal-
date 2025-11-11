public class Gpu extends Producto{
    private int memoria;

    public Gpu(double precio, String marca, String modelo, int memoria) {
        super(precio, marca, modelo);
        this.memoria = memoria;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "Gpu{" +
                super.toString()+
                "memoria=" + memoria +
                "} " +"\n\n";
    }
}
