package Clases;

import org.json.JSONObject;

public abstract class Producto {
    //ATRIBUTOS
    private int idProducto;
    private static int contador=0;
    private double precio;
    private String marca;
    private String modelo;

    //CONSTRUCTORES
    public Producto(double precio, String marca, String modelo) {
        this.idProducto = contador++;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Producto(JSONObject obj){
        this.idProducto = obj.getInt("idProducto");
        this.precio = obj.getDouble("precio");
        this.marca = obj.getString("marca");
        this.modelo = obj.getString("modelo");
    }

    //METODOS
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Producto.contador = contador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Clases.Producto{" +
                "idProducto=" + idProducto +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        json.put("idProducto", this.idProducto);
        json.put("precio", this.precio);
        json.put("marca", this.marca);
        json.put("modelo", this.modelo);
        return json;
    }
}
