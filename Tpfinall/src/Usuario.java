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
    private Carrito<Producto> carritoProductos;

    public Usuario(String usuario, String contraseña, String nombre, String gmail) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.gmail = gmail;
        this.tipoDelUsuario = TipoUsuario.logueado;
        this.metodosDePago = new HashSet<>();
        this.carritoProductos = new Carrito<>();
    }

    public Usuario(String usuario, String contraseña, String nombre, String gmail, TipoUsuario tipoUsuario) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.gmail = gmail;
        this.tipoDelUsuario = tipoUsuario;
        this.metodosDePago = new HashSet<>();
        this.carritoProductos = new Carrito<>();
    }

    public Usuario(){
        this.usuario = null;
        this.contraseña = null;
        this.nombre = null;
        this.gmail = null;
        this.tipoDelUsuario = TipoUsuario.noLogueado;
        this.metodosDePago = new HashSet<>();
        this.carritoProductos = new Carrito<>();
    }

    public Usuario(JSONObject obj){
        this.usuario = obj.getString("usuario");
        this.contraseña = obj.getString("contraseña");
        this.nombre = obj.getString("nombre");
        this.gmail = obj.getString("gmail");
        this.tipoDelUsuario = TipoUsuario.valueOf(obj.getString("tipoDelUsuario"));
        this.metodosDePago = new HashSet<>();

        JSONArray metodosArray = obj.getJSONArray("metodosDePago");
        for (int i = 0; i < metodosArray.length(); i++) {
            JSONObject tarjetasJson = metodosArray.getJSONObject(i);
            MetodoDePago tarjeta = new MetodoDePago(tarjetasJson);
            this.metodosDePago.add(tarjeta);
        }

        if(obj.has("carritoProductos")){
            this.carritoProductos = new Carrito<>(obj.getJSONObject("carritoProductos"));
        } else {
            this.carritoProductos = new Carrito<>();
        }
    }

    public void vaciarCarrito(){
        this.carritoProductos.getCarrito().clear();
    }

    public Carrito<Producto> getCarritoProductos() {
        return carritoProductos;
    }

    public HashSet<MetodoDePago> getMetodosDePago() {
        return metodosDePago;
    }

    public boolean añadirProductoAlCarrito(Producto p){
        return this.carritoProductos.agregarAlCarrito(p);
    }

    public String mostrarProductos(){
        StringBuilder contenido = new StringBuilder();
            for(Producto producto : this.carritoProductos.getCarrito()){
                contenido.append(producto);
            }
        return contenido.toString();
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

        json.put("carritoProductos", this.carritoProductos.toJSON());

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
