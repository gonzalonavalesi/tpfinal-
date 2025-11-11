import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {
    private int id;
    private static int contador=0;
    private LocalDateTime fecha;
    private String nombreUsuario;
    private ArrayList<Producto>productoArrayList;

    public Ticket(int id, String nombreUsuario) {
        this.id = contador++;
        this.fecha = LocalDateTime.now();
        this.nombreUsuario = nombreUsuario;
        this.productoArrayList = new ArrayList<>();
    }

    public boolean agregarProductosDesdeCarrito(Carrito<Producto> carrito){
        return this.productoArrayList.addAll(carrito.getCarrito());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Ticket.contador = contador;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", productoArrayList=" + productoArrayList +
                '}';
    }

    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("fecha", this.fecha.toString());
        json.put("nombreUsuario", this.nombreUsuario);

        JSONArray productosArray = new JSONArray();
        for(Producto producto : this.productoArrayList){
            productosArray.put(producto.toJSON());
        }
        json.put("productos", productosArray);

        return json;
    }

    public String mostrarProductos(){
        StringBuilder contenido = new StringBuilder();
        for(Producto producto : this.productoArrayList){
            contenido.append(producto);
        }
        return contenido.toString();
    }
}
