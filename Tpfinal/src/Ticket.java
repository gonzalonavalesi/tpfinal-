import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Ticket {
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private Usuario comprador;
    private ArrayList<Producto> items;
    private static final double iva = 0.21;
    private double subTotal = 0;
    private double ivaTotal = 0;
    private double totalCompra = 0;

    public Ticket(){
        this.fechaEmision = LocalDateTime.now();
        this.numeroFactura = UUID.randomUUID().toString().substring(0,0).toUpperCase();
        this.items = new ArrayList<>();
    }


    public String getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public ArrayList<Producto> getItems() {
        return items;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getIvaTotal() {
        return ivaTotal;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public String generarNumeroFactura(){
        return "F-" +UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public boolean agregarProductoTicket(Producto producto) {
        subTotal = this.subTotal + producto.getPrecio();
        return items.add(producto);
    }

    public void calcularTotales(){
        for(Producto producto : items){
            ivaTotal = subTotal * 0.21;
            totalCompra = subTotal + ivaTotal;
        }
    }

    public String imprimirTicket(){

        calcularTotales();
        StringBuilder info = new StringBuilder();
        //DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        info.append("------------ TICKET DE COMPRA -------------------\n");
        info.append("Tekno Computacion\n");
        info.append("CUIT: 23-12345678-3  IVA: 0.21\n");
        info.append("Direccion: San Juan 1285\n");
        info.append("--------------------------------------------------\n");
        info.append("Factura: "+numeroFactura+ "Fecha: "+fechaEmision+"\n");
        info.append("Cliente: "+comprador.getNombre()+"\n");
        info.append("--------------------------------------------------\n");
        info.append("SubTotal: "+subTotal+"\n");
        info.append("Iva: "+ivaTotal+"\n");
        info.append("TOTAL: "+totalCompra+"\n");
        info.append("--------------------------------------------------\n");
        info.append("Gracias por su compra");
        return info.toString();
    }

    public JSONObject toJson(){
        JSONObject jsonTicket = new JSONObject();
        jsonTicket.put("numeroFactura", numeroFactura);
        jsonTicket.put("fechaEmision", fechaEmision.toString());
        comprador.toJSON();
        JSONArray jsonItems = new JSONArray();
        for(Producto p : items){
            jsonItems.put(p.toJSON());
        }
        jsonTicket.put("items", jsonItems);
        jsonTicket.put("subTotal", subTotal);
        jsonTicket.put("ivaTotal", ivaTotal);
        jsonTicket.put("totalCompra", totalCompra);

        return jsonTicket;
    }
}
