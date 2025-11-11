import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Usuario {
    private String usuario;
    private String contraseña;
    private String nombre;
    private String gmail;
    private TipoUsuario tipoDelUsuario;
    private HashSet<MetodoDePago> metodosDePago;

    public Usuario(String usuario, String contraseña, String nombre, String gmail) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.gmail = gmail;
        this.tipoDelUsuario = TipoUsuario.logueado;
        this.metodosDePago = new HashSet<>();
    }

    public Usuario(){
        this.usuario = null;
        this.contraseña = null;
        this.nombre = null;
        this.gmail = null;
        this.tipoDelUsuario = TipoUsuario.noLogueado;
        this.metodosDePago = new HashSet<>();
    }

    public Usuario(JSONObject obj){
        this.usuario = obj.getString("usuario");
        this.contraseña = obj.getString("contraseña");
        this.nombre = obj.getString("nombre");
        this.gmail = obj.getString("gmail");
        this.tipoDelUsuario = TipoUsuario.valueOf(obj.getString("tipoDelUsuario")); // CORREGIDO
        this.metodosDePago = new HashSet<>();

        JSONArray metodosArray = obj.getJSONArray("metodosDePago");

        for (int i = 0; i < metodosArray.length(); i++) {
            JSONObject tarjetasJson = metodosArray.getJSONObject(i);
            MetodoDePago tarjeta = new MetodoDePago(tarjetasJson);
            this.metodosDePago.add(tarjeta);
        }
    }

    public boolean añadirTarjeta(TipoMetodoDePago tipoTarjeta, String numeroTarjeta, int año, int mes, int dia, int cvv){
        return this.metodosDePago.add(new MetodoDePago(tipoTarjeta, numeroTarjeta, año, mes, dia, cvv));
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoDelUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoDelUsuario = tipoUsuario;
    }

    public HashSet<MetodoDePago> getMetodosDePago() {
        return metodosDePago;
    }

    public void setMetodosDePago(HashSet<MetodoDePago> metodosDePago) {
        this.metodosDePago = metodosDePago;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", nombre='" + nombre + '\'' +
                ", gmail='" + gmail + '\'' +
                ", tipoUsuario=" + tipoDelUsuario +
                ", metodosDePago=" + metodosDePago +
                '}'+"\n";
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("usuario", this.usuario);
        json.put("contraseña", this.contraseña);
        json.put("nombre", this.nombre);
        json.put("gmail", this.gmail);
        json.put("tipoDelUsuario", this.tipoDelUsuario.toString());

        JSONArray metodosArray = new JSONArray();
        for (MetodoDePago metodo : this.metodosDePago) {
            metodosArray.put(metodo.toJSON());
        }
        json.put("metodosDePago", metodosArray);

        return json;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario usuario1)) return false;
        return Objects.equals(usuario, usuario1.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario);
    }
}
