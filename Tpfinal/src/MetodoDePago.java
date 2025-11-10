import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class MetodoDePago {
    private TipoMetodoDePago tipoTarjeta;
    private String numeroTarjeta;
    private LocalDate fechaCaducidad;
    private int cvv;

    public MetodoDePago(TipoMetodoDePago tipoTarjeta, String numeroTarjeta, int año, int mes, int dia, int cvv) {
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = LocalDate.of(año, mes, dia);
        this.cvv = cvv;
    }

    public MetodoDePago(JSONObject obj) {
        this.tipoTarjeta = TipoMetodoDePago.valueOf(obj.getString("tipoTarjeta"));
        this.numeroTarjeta = obj.getString("numeroTarjeta");
        this.cvv = obj.getInt("cvv");
        String fecha = obj.getString("fechaCaducidad");
        this.fechaCaducidad = LocalDate.parse(fecha);
    }

    public TipoMetodoDePago getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoMetodoDePago tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "MetodoDePago{" +
                "tipoTarjeta=" + tipoTarjeta +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaCaducidad=" + fechaCaducidad +
                ", cvv=" + cvv +
                '}' + "\n";
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        try{
            json.put("tipoTarjeta", this.tipoTarjeta.toString());
            json.put("numeroTarjeta", this.numeroTarjeta);
            json.put("fechaCaducidad", this.fechaCaducidad.toString());
            json.put("cvv", this.cvv);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MetodoDePago that)) return false;
        return Objects.equals(numeroTarjeta, that.numeroTarjeta);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroTarjeta);
    }
}
