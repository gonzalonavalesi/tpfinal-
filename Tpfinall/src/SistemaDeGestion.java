import Clases.*;
import Enums.*;
import Exceptions.ExceptionCarritoIsNULL;
import Exceptions.ExceptionMetodoDePagoNotFound;
import Exceptions.ExceptionUsuarioInvalido;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class SistemaDeGestion {
    private HashSet<Usuario> arregloUsuarios;
    private HashSet<Producto> productoHashSet;
    private HashSet<Ticket>ticketsGenerados;

    public SistemaDeGestion() {
        this.arregloUsuarios = new HashSet<>();
        this.productoHashSet =new HashSet<>();
        this.ticketsGenerados=new HashSet<>();
    }

    //CONSTRUCTORES
    public SistemaDeGestion(JSONArray arreglo){
        this.arregloUsuarios = new HashSet<>();
        this.productoHashSet = new HashSet<>();
        this.ticketsGenerados=new HashSet<>();
        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject obj = arreglo.getJSONObject(i);

            if(obj.has("usuario") && obj.has("contraseña")){
                this.arregloUsuarios.add(new Usuario(obj));
            }
            else if(obj.has("tipo")){
                String tipo = obj.getString("tipo");

                switch(tipo){
                    case "Clases.Almacenamiento":
                        this.productoHashSet.add(new Almacenamiento(obj));
                        break;
                    case "Clases.Cpu":
                        this.productoHashSet.add(new Cpu(obj));
                        break;
                    case "Clases.Gpu":
                        this.productoHashSet.add(new Gpu(obj));
                        break;
                    case "Clases.MotherBoard":
                        this.productoHashSet.add(new MotherBoard(obj));
                        break;
                    case "Clases.Ram":
                        this.productoHashSet.add(new Ram(obj));
                        break;
                    case "Clases.Refrigeracion":
                        this.productoHashSet.add(new Refrigeracion(obj));
                        break;
                    case "Clases.Combos":
                        this.productoHashSet.add(new Combos(obj));
                        break;
                    case "Clases.Fuente":
                        this.productoHashSet.add(new Fuente(obj));
                        break;
                    case "Clases.Gabinete":
                        this.productoHashSet.add(new Gabinete(obj));
                        break;
                    case "Clases.Mouse":
                        this.productoHashSet.add(new Mouse(obj));
                        break;
                    case "Clases.Teclado":
                        this.productoHashSet.add(new Teclado(obj));
                        break;
                    case "Clases.Auricular":
                        this.productoHashSet.add(new Auricular(obj));
                        break;
                    case "Clases.Monitor":
                        this.productoHashSet.add(new Monitor(obj));
                        break;
                    case "Clases.MousePad":
                        this.productoHashSet.add(new MousePad(obj));
                        break;
                    case "Clases.ComputadoraEscritorio":
                        this.productoHashSet.add(new ComputadoraEscritorio(obj));
                        break;
                    case "Clases.Notebook":
                        this.productoHashSet.add(new Notebook(obj));
                        break;
                }
            }
        }

    }

    //METODOS

    //AGREGAR USUARIO
    public boolean agregarUsuario(String usuario, String contraseña, String nombre, String gmail) {
        return this.arregloUsuarios.add(new Usuario(usuario, contraseña, nombre, gmail));
    }

    //AGREGAR USUARIO MANUAL
    public boolean agregarUsuarioManualmente(String usuario, String contraseña, String nombre, String gmail, TipoUsuario permisos) {
        return this.arregloUsuarios.add(new Usuario(usuario, contraseña, nombre, gmail, permisos));
    }

    //AGREGAR METODO DE PAGO A USUARIO
    public boolean agregarMetodoDePago(String nombreUsuario, TipoMetodoDePago tipoTarjeta, String numeroTarjeta, int año, int mes, int dia, int cvv) {
        Iterator<Usuario>iterator = this.arregloUsuarios.iterator();
        while(iterator.hasNext()){
            Usuario usuario = iterator.next();
            if(nombreUsuario.equalsIgnoreCase(usuario.getNombre())){
                return usuario.añadirTarjeta(tipoTarjeta, numeroTarjeta, año, mes, dia, cvv);
            }
        }
        return false;
    }

    //ACTUALIZAR USUSARIO
    public Usuario actualizarUsuario(String nombreUsuario){
        for(Usuario usuarios : this.arregloUsuarios){
            if(usuarios.getUsuario().equalsIgnoreCase(nombreUsuario)){
                return usuarios;
            }
        }
        return null;
    }

    //AGREGAMOS UN PRODUCTO AL CARRITO DEL USUSARIO ACTUAL
    public boolean agregarProductoAlCarrito(int id, String nombreUsuario){
        for(Usuario usuarios : this.arregloUsuarios){
            if(usuarios.getNombre().equalsIgnoreCase(nombreUsuario)){
                for(Producto producto : this.productoHashSet){
                    if(producto.getIdProducto() == id){
                        return usuarios.añadirProductoAlCarrito(producto);
                    }
                }
            }
        }
        return false;
    }

    //MOSTRAR EL CARRITO
    public String mostrarCarrito(String nombreUsuario){
        StringBuilder contenido = new StringBuilder();
        for(Usuario usuario : this.arregloUsuarios){
            if(nombreUsuario.equalsIgnoreCase(usuario.getNombre())){
                contenido.append(usuario.mostrarProductos());
            }
        }
        return contenido.toString();
    }

    //LOG IN
    public Usuario hacerLogin(String usuario, String contraseña)throws ExceptionUsuarioInvalido {
        for(Usuario usuarios : this.arregloUsuarios){
            if(usuarios.getUsuario().equalsIgnoreCase(usuario)){
                if(usuarios.getContraseña().equalsIgnoreCase(contraseña)){
                    return usuarios;
                }else {
                    throw new ExceptionUsuarioInvalido("Contraseña incorrecta, continuaras deslogueado");
                }
            }
        }
        throw new ExceptionUsuarioInvalido("Nombre de usuario invalido");
    }

    //VER USUARIOS
    public String mostrarUsuarios(){
        StringBuilder contenido = new StringBuilder();
        for(Usuario usuario : this.arregloUsuarios){
            contenido.append(usuario);
        }
        return contenido.toString();
    }

    //SISTEMA PARA AGREGAR COSAS COMO ADMIN
    public boolean agregarAlmacenamiento(double precio, String marca, String modelo, TipoAlmacenamiento tipoAlmacenamiento, int gb){
        Iterator<Producto>iterator=productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto=iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Almacenamiento(precio,marca,modelo,tipoAlmacenamiento,gb));
    }

    public boolean agregarCpu(double precio, String marca, String modelo, Socket socket, int nucleos, int hilos, String integrados){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Cpu(precio, marca, modelo, socket, nucleos, hilos, integrados));
    }

    public boolean agregarGpu(double precio, String marca, String modelo, int memoria){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Gpu(precio, marca, modelo, memoria));
    }

    public boolean agregarMotherBoard(double precio, String marca, String modelo, Socket socket){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new MotherBoard(precio, marca, modelo, socket));
    }

    public boolean agregarRam(double precio, String marca, String modelo, TipoMemoria tipoMemoria, int gb){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Ram(precio, marca, modelo, tipoMemoria, gb));
    }

    public boolean agregarRefrigeracion(double precio, String marca, String modelo, Socket socket, TipoRefrigeracion refrigeracion){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Refrigeracion(precio, marca, modelo, socket, refrigeracion));
    }

    public boolean agregarFuente(double precio, String marca, String modelo, int watts, Certificacion certificacion){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Fuente(precio, marca, modelo, watts, certificacion));
    }

    public boolean agregarGabinete(boolean rgb, double precio, String marca, String modelo){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto.getModelo().equalsIgnoreCase(modelo)){
                return false;
            }
        }
        return productoHashSet.add(new Gabinete(rgb, precio, marca, modelo));
    }

    public boolean agregarMouse(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, ArrayList<Integer> dpi){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto instanceof Periferico){
                Periferico periferico = (Periferico) producto;
                if((periferico.getModelo().equalsIgnoreCase(modelo)) && periferico.getColor().equalsIgnoreCase(color)){
                    return false;
                }
            }
        }
        return productoHashSet.add(new Mouse(precio, marca, modelo, color, rgb, inalambrico, dpi));
    }

    public boolean agregarTeclado(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, TipoTeclado tipoTeclado, TipoMecanismo tipoMecanismo){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto instanceof Periferico){
                Periferico periferico = (Periferico) producto;
                if((periferico.getModelo().equalsIgnoreCase(modelo)) && periferico.getColor().equalsIgnoreCase(color)){
                    return false;
                }
            }
        }
        return productoHashSet.add(new Teclado(precio, marca, modelo, color, rgb, inalambrico, tipoTeclado, tipoMecanismo));
    }

    public boolean agregarAuricular(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String audio, boolean microfono){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto instanceof Periferico){
                Periferico periferico = (Periferico) producto;
                if((periferico.getModelo().equalsIgnoreCase(modelo)) && periferico.getColor().equalsIgnoreCase(color)){
                    return false;
                }
            }
        }
        return productoHashSet.add(new Auricular(precio, marca, modelo, color, rgb, inalambrico, audio, microfono));
    }

    public boolean agregarMonitor(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, double pulgadas, String calidadPantalla, boolean curvo, int frecuencia, int tiempoRespuesta){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto instanceof Periferico){
                Periferico periferico = (Periferico) producto;
                if((periferico.getModelo().equalsIgnoreCase(modelo)) && periferico.getColor().equalsIgnoreCase(color)){
                    return false;
                }
            }
        }
        return productoHashSet.add(new Monitor(precio, marca, modelo, color, rgb, inalambrico, pulgadas, calidadPantalla, curvo, frecuencia, tiempoRespuesta));
    }

    public boolean agregarMousePad(double precio, String marca, String modelo, String color, boolean rgb, boolean inalambrico, String tipoSuperficie, String tamaño){
        Iterator<Producto> iterator = productoHashSet.iterator();
        while(iterator.hasNext()){
            Producto producto = iterator.next();
            if(producto instanceof Periferico){
                Periferico periferico = (Periferico) producto;
                if((periferico.getModelo().equalsIgnoreCase(modelo)) && periferico.getColor().equalsIgnoreCase(color)){
                    return false;
                }
            }
        }
        return productoHashSet.add(new MousePad(precio, marca, modelo, color, rgb, inalambrico, tipoSuperficie, tamaño));
    }

    //VER PRODUCTOS AGREAGDOS
    public String verProductos(){
        StringBuilder contenido = new StringBuilder();
        for(Producto productos : this.productoHashSet){
            contenido.append(productos);
        }
        return contenido.toString();
    }

    //ELIMINAR PRODUCTO
    public boolean eliminarProducto(int id){
        Iterator<Producto>iterator=productoHashSet.iterator();
        if((id<0)&&(id>productoHashSet.size())){
            return false;
        }
        while (iterator.hasNext()){
            Producto producto=iterator.next();
            if(producto.getIdProducto()==id){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    //MODIFICAR PRODUCTO
    public boolean modificarPrecio(double precio, int id){
        if((id<0)&&(id>productoHashSet.size())){
            return false;
        }
        Iterator<Producto>iterator= productoHashSet.iterator();
        while (iterator.hasNext()){
            Producto producto=iterator.next();
            if(producto.getIdProducto()==id){
                producto.setPrecio(precio);
                return true;
            }
        }
        return false;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "SistemaDeGestion{" +
                "arregloUsuarios=" + arregloUsuarios +
                '}'+"\n";
    }

    //TOJSOn
    public JSONArray toJSON() {
        JSONArray array = new JSONArray();

        // Agregar todos los usuarios
        for (Usuario usuario : this.arregloUsuarios) {
            array.put(usuario.toJSON());
        }

        return array;
    }

    //TICKETS TOJSON
    public JSONArray ticketsToJSON() {
        JSONArray ticketsArray = new JSONArray();
        for (Ticket ticket : this.ticketsGenerados) {
            ticketsArray.put(ticket.toJSON());
        }
        return ticketsArray;
    }

    //REALIZAR COMPRA
    public Ticket realizarCompra(String nombreUsuario) throws ExceptionCarritoIsNULL, ExceptionMetodoDePagoNotFound {
        for(Usuario usuario : this.arregloUsuarios){
            if(usuario.getNombre().equalsIgnoreCase(nombreUsuario)){
                if(usuario.getCarritoProductos().getCarrito().isEmpty()){
                    throw new ExceptionCarritoIsNULL("No se pudo realizar la compra.\n"+ "Verifica que tengas productos en el carrito.");
                }
                if(usuario.getMetodosDePago().isEmpty()){
                    throw new ExceptionMetodoDePagoNotFound("No se pudo realizar la compra.\n"+ "Verifica que tengas un metodo de pago registrado.");
                }
                Ticket ticket = new Ticket(0, nombreUsuario);
                ticket.agregarProductosDesdeCarrito(usuario.getCarritoProductos());

                this.ticketsGenerados.add(ticket);

                usuario.vaciarCarrito();
                return ticket;
            }
        }
        return null;
    }

    //OBTENER EL TOTAL DE LA PC DE ESCRITORIO
    public String obtenerTotalComputadoraEscritorio(){
        double total = 0;
        String info = "";
        for(Producto p : this.productoHashSet){
            if (p instanceof ComputadoraEscritorio){
                total += ((ComputadoraEscritorio) p).GetTotal();
            }
        }
        info = "El total de la Computadora de Escritorio es de: $"+ total;
        return info;
    }
    public boolean agregarCombo(Combos combo) {
        return this.productoHashSet.add(combo);
    }

    //AGREGAR PC ESCRITORIO
    public boolean agregarComputadoraEscritorio(double precio, String marca, String modelo, double precioCPU, String marcaCPU, String modeloCPU, Socket socketCPU, int nucleosCPU, int hilosCPU, String integradosCPU, double precioGPU, String marcaGPU, String modeloGPU, int memoriaGPU, double precioMother, String marcaMother, String modeloMother, Socket socketMother, double precioAlmacenamiento, String marcaAlmacenamiento, String modeloAlmacenamiento, TipoAlmacenamiento tipoAlmacenamiento, int gbAlmacenamiento, double precioRam, String marcaRam, String modeloRam, TipoMemoria tipoMemoria, int gbRam, double precioRefrigeracion, String marcaRefrigeracion, String modeloRefrigeracion, Socket socketRefrigeracion, TipoRefrigeracion refrigeracion, double precioFuente, String marcaFuente, String modeloFuente, int wattsFuente, Certificacion certificacionFuente, boolean rgbGabinete, double precioGabinete, String marcaGabinete, String modeloGabinete) {

        ComputadoraEscritorio pc = new ComputadoraEscritorio(precio, marca, modelo, precioCPU, marcaCPU, modeloCPU, socketCPU, nucleosCPU, hilosCPU, integradosCPU, precioGPU, marcaGPU, modeloGPU, memoriaGPU, precioMother, marcaMother, modeloMother, socketMother, precioAlmacenamiento, marcaAlmacenamiento, modeloAlmacenamiento, tipoAlmacenamiento, gbAlmacenamiento, precioRam, marcaRam, modeloRam, tipoMemoria, gbRam, precioRefrigeracion, marcaRefrigeracion, modeloRefrigeracion, socketRefrigeracion, refrigeracion, precioFuente, marcaFuente, modeloFuente, wattsFuente, certificacionFuente, rgbGabinete, precioGabinete, marcaGabinete, modeloGabinete);

        return this.productoHashSet.add(pc);
    }

    //BUSCARPRODUCTO PARA EL COMBO
    public Producto buscarProductoPorId(int id) {
        for (Producto producto : this.productoHashSet) {
            if (producto.getIdProducto() == id) {
                return producto;
            }
        }
        return null;
    }

    //AGREGAR NOTEBOOK
    public boolean agregarNotebook(double precio, String marca, String modelo, double precioCPU, String marcaCPU, String modeloCPU, Socket socket, int nucleos, int hilos, String integrados, double precioGPU, String marcaGPU, String modeloGPU, int memoriaGPU, double precioAlmacenamiento, String marcaAlmacenamiento, String modeloAlmacenamiento, TipoAlmacenamiento tipoAlmacenamiento, int gbAlmacenamiento, double precioRam, String marcaRam, String modeloRam, TipoMemoria tipoMemoria, int gbRam, int bateria, String calidadPantalla, double pulgadas, double precioMother, String marcaMother, String modeloMother, Socket socketMother) {
        Notebook notebook = new Notebook(precio, marca, modelo, precioCPU, marcaCPU, modeloCPU, socket, nucleos, hilos, integrados, precioGPU, marcaGPU, modeloGPU, memoriaGPU, precioAlmacenamiento, marcaAlmacenamiento, modeloAlmacenamiento, tipoAlmacenamiento, gbAlmacenamiento, precioRam, marcaRam, modeloRam, tipoMemoria, gbRam, bateria, calidadPantalla, pulgadas, precioMother, marcaMother, modeloMother, socketMother);
        return this.productoHashSet.add(notebook);
    }

    //OBTENER TOTAL COMBO
    public String obtenerTotalCombo(){
        double total = 0;
        for(Producto p : this.productoHashSet){
            if (p instanceof Combos){
                total += ((Combos) p).GetTotal();
            }
        }
        return "El total del/los combo/s es de: $" + total;
    }
}
