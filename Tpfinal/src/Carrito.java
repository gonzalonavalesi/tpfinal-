import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Carrito <T>{
    private ArrayList<T> carrito;

    public Carrito(){
        this.carrito = new ArrayList<>();
    }

    public void agregarAlCarrito (T t){
        carrito.add(t);
    }

    public void eliminarDelCarrito (int pos){
        carrito.remove(pos);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "carrito=" + carrito +
                '}';
    }

}
