public class Notebook extends Producto{
    private Cpu cpu;
    private MotherBoard motherBoard;
    private Gpu gpu;
    private Almacenamiento almacenamiento;
    private Ram ram;
    private int bateria;
    private String calidadPantalla;
    private double pulgadas;

    public Notebook(double precio, String marca, String modelo, double precioCPU, String marcaCPU, String modeloCPU, Socket socket, int nucleos, int hilos, String integrados, double precioGPU, String marcaGPU, String modeloGPU, int memoriaGPU, double precioAlmacenamiento, String marcaAlmacenamiento, String modeloAlmacenamiento, TipoAlmacenamiento tipoAlmacenamiento, int gbAlmacenamiento,double precioRam, String marcaRam, String modeloRam, TipoMemoria tipoMemoria, int gbRam, int bateria, String calidadPantalla, double pulgadas,double precioMother, String marcaMother, String modeloMother, Socket socketMother) {
        super(precio, marca, modelo);
        this.cpu = new Cpu(precioCPU,marcaCPU,modeloCPU,socket,nucleos,hilos,integrados);
        this.gpu = new Gpu(precioGPU,marcaGPU,modeloGPU,memoriaGPU);
        this.almacenamiento = new Almacenamiento(precioAlmacenamiento,marcaAlmacenamiento,modeloAlmacenamiento,tipoAlmacenamiento,gbAlmacenamiento);
        this.ram = new Ram(precioRam,marcaRam,modeloRam,tipoMemoria,gbRam);
        this.bateria = bateria;
        this.calidadPantalla = calidadPantalla;
        this.pulgadas = pulgadas;
        this.motherBoard=new MotherBoard(precioMother,marcaMother,modeloMother,socketMother);
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public Almacenamiento getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public String getCalidadPantalla() {
        return calidadPantalla;
    }

    public void setCalidadPantalla(String calidadPantalla) {
        this.calidadPantalla = calidadPantalla;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    @Override
    public String toString() {
        return "==Notebook{" +
                super.toString() +
                cpu +
                motherBoard +
                gpu +
                almacenamiento +
                ram +
                "bateria=" + bateria +
                "calidadPantalla='" + calidadPantalla + "\n\n" +
                "pulgadas=" + pulgadas +
                "} " + "\n\n";
    }
}
