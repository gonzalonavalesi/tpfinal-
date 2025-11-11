public class MotherBoard extends Producto{
    private Socket socket;

    public MotherBoard(double precio, String marca, String modelo, Socket socket) {
        super(precio, marca, modelo);
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "MotherBoard{" +
                super.toString()+
                "socket=" + socket +
                "} " + "\n\n";
    }
}
