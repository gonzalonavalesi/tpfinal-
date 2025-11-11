public class Cpu extends Producto{
    private Socket socket;
    private int nucleos;
    private int hilos;
    private String integrados;

    public Cpu(double precio, String marca, String modelo, Socket socket, int nucleos, int hilos, String integrados) {
        super(precio, marca, modelo);
        this.socket = socket;
        this.nucleos = nucleos;
        this.hilos = hilos;
        this.integrados = integrados;
    }

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
        return "Cpu{" +
                super.toString() +
                "socket=" + socket +
                ", nucleos=" + nucleos +
                ", hilos=" + hilos +
                ", integrados='" + integrados + '\'' +
                "} " + "\n\n";
    }
}
