public class CableYadaptador extends Producto {
    private TipoAdaptador punta1;
    private TipoAdaptador punta2;

    public CableYadaptador(TipoAdaptador punta1, TipoAdaptador punta2) {
        this.punta1 = punta1;
        this.punta2 = punta2;
    }

    public TipoAdaptador getPunta1() {
        return punta1;
    }

    public void setPunta1(TipoAdaptador punta1) {
        this.punta1 = punta1;
    }

    public TipoAdaptador getPunta2() {
        return punta2;
    }

    public void setPunta2(TipoAdaptador punta2) {
        this.punta2 = punta2;
    }

    @Override
    public String toString() {
        return "CableYadaptador{" +
                "punta1=" + punta1 +
                ", punta2=" + punta2 +
                '}';
    }
}
