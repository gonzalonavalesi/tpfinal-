import org.json.JSONObject;

public class ComputadoraEscritorio extends Producto{
    private Cpu cpu;
    private Gpu gpu;
    private MotherBoard motherBoard;
    private Almacenamiento almacenamiento;
    private Ram ram;
    private Refrigeracion refrigeracion;
    private Fuente fuente;
    private Gabinete gabinete;

    public ComputadoraEscritorio(double precio, String marca, String modelo,double precioCPU, String marcaCPU, String modeloCPU, Socket socketCPU, int nucleosCPU, int hilosCPU, String integradosCPU,double precioGPU, String marcaGPU, String modeloGPU, int memoriaGPU,double precioMother, String marcaMother, String modeloMother, Socket socketMother,double precioAlmacenamiento, String marcaAlmacenamiento, String modeloAlmacenamiento, TipoAlmacenamiento tipoAlmacenamiento, int gbAlmacenamiento,double precioRam, String marcaRam, String modeloRam, TipoMemoria tipoMemoria, int gbRam, double precioRefrigeracion, String marcaRefrigeracion, String modeloRefrigeracion, Socket socketRefrigeracion, TipoRefrigeracion refrigeracion, double precioFuente, String marcaFuente, String modeloFuente, int wattsFuente, Certificacion certificacionFuente, boolean rgbGabinete,double precioGabinete, String marcaGabinete, String modeloGabinete) {
        super(precio, marca, modelo);
        this.cpu = new Cpu(precioCPU,marcaCPU,modeloCPU,socketCPU,nucleosCPU,hilosCPU,integradosCPU);
        this.gpu = new Gpu(precioGPU,marcaGPU,modeloGPU,memoriaGPU);
        this.motherBoard = new MotherBoard(precioMother,marcaMother,modeloMother,socketMother);
        this.almacenamiento = new Almacenamiento(precioAlmacenamiento,marcaAlmacenamiento,modeloAlmacenamiento,tipoAlmacenamiento,gbAlmacenamiento);
        this.ram = new Ram(precioRam,marcaRam,modeloRam,tipoMemoria,gbRam);
        this.refrigeracion = new Refrigeracion(precioRefrigeracion,marcaRefrigeracion,modeloRefrigeracion,socketRefrigeracion,refrigeracion);
        this.fuente = new Fuente(precioFuente,marcaFuente,modeloFuente,wattsFuente,certificacionFuente);
        this.gabinete = new Gabinete(rgbGabinete,precioGabinete,marcaGabinete,modeloGabinete);
    }

    public ComputadoraEscritorio(JSONObject obj){
        super(obj);
        this.cpu = new Cpu(obj.getJSONObject("cpu"));
        this.gpu = new Gpu(obj.getJSONObject("gpu"));
        this.motherBoard = new MotherBoard(obj.getJSONObject("motherBoard"));
        this.almacenamiento = new Almacenamiento(obj.getJSONObject("almacenamiento"));
        this.ram = new Ram(obj.getJSONObject("ram"));
        this.refrigeracion = new Refrigeracion(obj.getJSONObject("refrigeracion"));
        this.fuente = new Fuente(obj.getJSONObject("fuente"));
        this.gabinete = new Gabinete(obj.getJSONObject("gabinete"));
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

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
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

    public Refrigeracion getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(Refrigeracion refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public void setGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
    }

    @Override
    public String toString() {
        return "==ComputadoraEscritorio{" +
                super.toString()+
                 cpu +
                 gpu +
                 motherBoard +
                 almacenamiento +
                 ram +
                 refrigeracion +
                 fuente +
                 gabinete +
                "} " +"\n\n";
    }

    @Override
    public JSONObject toJSON(){
        JSONObject json = super.toJSON();
        json.put("tipo", "ComputadoraEscritorio");
        json.put("cpu", this.cpu.toJSON());
        json.put("gpu", this.gpu.toJSON());
        json.put("motherBoard", this.motherBoard.toJSON());
        json.put("almacenamiento", this.almacenamiento.toJSON());
        json.put("ram", this.ram.toJSON());
        json.put("refrigeracion", this.refrigeracion.toJSON());
        json.put("fuente", this.fuente.toJSON());
        json.put("gabinete", this.gabinete.toJSON());
        return json;
    }
}
