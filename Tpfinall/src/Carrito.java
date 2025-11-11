import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Carrito <T>{
    private ArrayList<T> carrito;

    public Carrito(){
        this.carrito = new ArrayList<>();
    }

    public Carrito(JSONObject obj){
        this.carrito = new ArrayList<>();
        JSONArray carritoArray = obj.getJSONArray("carrito");

        for(int i = 0; i < carritoArray.length(); i++){
            JSONObject productoObj = carritoArray.getJSONObject(i);
            String tipo = productoObj.getString("tipo");

            switch(tipo){
                case "Almacenamiento":
                    this.carrito.add((T) new Almacenamiento(productoObj));
                    break;
                case "Cpu":
                    this.carrito.add((T) new Cpu(productoObj));
                    break;
                case "Gpu":
                    this.carrito.add((T) new Gpu(productoObj));
                    break;
                case "MotherBoard":
                    this.carrito.add((T) new MotherBoard(productoObj));
                    break;
                case "Ram":
                    this.carrito.add((T) new Ram(productoObj));
                    break;
                case "Refrigeracion":
                    this.carrito.add((T) new Refrigeracion(productoObj));
                    break;
                case "Fuente":
                    this.carrito.add((T) new Fuente(productoObj));
                    break;
                case "Gabinete":
                    this.carrito.add((T) new Gabinete(productoObj));
                    break;
                case "Mouse":
                    this.carrito.add((T) new Mouse(productoObj));
                    break;
                case "Teclado":
                    this.carrito.add((T) new Teclado(productoObj));
                    break;
                case "Auricular":
                    this.carrito.add((T) new Auricular(productoObj));
                    break;
                case "Monitor":
                    this.carrito.add((T) new Monitor(productoObj));
                    break;
                case "MousePad":
                    this.carrito.add((T) new MousePad(productoObj));
                    break;
                case "ComputadoraEscritorio":
                    this.carrito.add((T) new ComputadoraEscritorio(productoObj));
                    break;
                case "Notebook":
                    this.carrito.add((T) new Notebook(productoObj));
                    break;
            }
        }
    }

    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        JSONArray carritoArray = new JSONArray();

        for(T producto : this.carrito){
            if(producto instanceof Producto){
                carritoArray.put(((Producto)producto).toJSON());
            }
        }

        json.put("carrito", carritoArray);
        return json;
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
