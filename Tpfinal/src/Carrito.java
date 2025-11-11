import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Carrito <T>{
    private ArrayList<T> carrito;

    public Carrito(){
        this.carrito = new ArrayList<>();
    }

    public boolean agregarAlCarrito (T t){
        return this.carrito.add(t);
    }

    public void eliminarDelCarrito (int pos){
        carrito.remove(pos);
    }

    public String mostrarCarrito(){
        StringBuilder contenido = new StringBuilder();
        for(T carrito : this.carrito){
            contenido.append(carrito);
        }
        return contenido.toString();
    }

    public ArrayList<T> getCarrito() {
        return carrito;
    }

    @Override
    public String toString() {
        return "\nCarrito{" +
                "carrito=" + carrito +
                '}'+"\n";
    }

}
