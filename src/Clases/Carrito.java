package Clases;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Carrito <T>{
    //ATRIBUTOS
    private ArrayList<T> carrito;

    //CONSTRUCTORES
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
                case "Clases.Almacenamiento":
                    this.carrito.add((T) new Almacenamiento(productoObj));
                    break;
                case "Clases.Cpu":
                    this.carrito.add((T) new Cpu(productoObj));
                    break;
                case "Clases.Combos":
                    this.carrito.add((T) new Combos(productoObj));
                    break;
                case "Clases.Gpu":
                    this.carrito.add((T) new Gpu(productoObj));
                    break;
                case "Clases.MotherBoard":
                    this.carrito.add((T) new MotherBoard(productoObj));
                    break;
                case "Clases.Ram":
                    this.carrito.add((T) new Ram(productoObj));
                    break;
                case "Clases.Refrigeracion":
                    this.carrito.add((T) new Refrigeracion(productoObj));
                    break;
                case "Clases.Fuente":
                    this.carrito.add((T) new Fuente(productoObj));
                    break;
                case "Clases.Gabinete":
                    this.carrito.add((T) new Gabinete(productoObj));
                    break;
                case "Clases.Mouse":
                    this.carrito.add((T) new Mouse(productoObj));
                    break;
                case "Clases.Teclado":
                    this.carrito.add((T) new Teclado(productoObj));
                    break;
                case "Clases.Auricular":
                    this.carrito.add((T) new Auricular(productoObj));
                    break;
                case "Clases.Monitor":
                    this.carrito.add((T) new Monitor(productoObj));
                    break;
                case "Clases.MousePad":
                    this.carrito.add((T) new MousePad(productoObj));
                    break;
                case "Clases.ComputadoraEscritorio":
                    this.carrito.add((T) new ComputadoraEscritorio(productoObj));
                    break;
                case "Clases.Notebook":
                    this.carrito.add((T) new Notebook(productoObj));
                    break;
            }
        }
    }

    //METODOS
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
        return new ArrayList<>(carrito);
    }

    @Override
    public String toString() {
        return "\nClases.Carrito{" +
                "carrito=" + carrito +
                '}'+"\n";
    }

}
