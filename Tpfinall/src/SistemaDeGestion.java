import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.desktop.UserSessionEvent;
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

    /*public SistemaDeGestion(JSONArray arreglo){
        this.arregloUsuarios = new HashSet<>();
        this.productoHashSet = new HashSet<>();

        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject usuario = arreglo.getJSONObject(i);
            this.arregloUsuarios.add(new Usuario(usuario));
        }
    }*/
    public SistemaDeGestion(JSONArray arreglo){
        this.arregloUsuarios = new HashSet<>();
        this.productoHashSet = new HashSet<>();
        this.ticketsGenerados=new HashSet<>();
        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject obj = arreglo.getJSONObject(i);

            // Si es un usuario
            if(obj.has("usuario") && obj.has("contraseña")){
                this.arregloUsuarios.add(new Usuario(obj));
            }
            // Si es un producto
            else if(obj.has("tipo")){
                String tipo = obj.getString("tipo");

                switch(tipo){
                    case "Almacenamiento":
                        this.productoHashSet.add(new Almacenamiento(obj));
                        break;
                    case "Cpu":
                        this.productoHashSet.add(new Cpu(obj));
                        break;
                    case "Gpu":
                        this.productoHashSet.add(new Gpu(obj));
                        break;
                    case "MotherBoard":
                        this.productoHashSet.add(new MotherBoard(obj));
                        break;
                    case "Ram":
                        this.productoHashSet.add(new Ram(obj));
                        break;
                    case "Refrigeracion":
                        this.productoHashSet.add(new Refrigeracion(obj));
                        break;
                    case "Fuente":
                        this.productoHashSet.add(new Fuente(obj));
                        break;
                    case "Gabinete":
                        this.productoHashSet.add(new Gabinete(obj));
                        break;
                    case "Mouse":
                        this.productoHashSet.add(new Mouse(obj));
                        break;
                    case "Teclado":
                        this.productoHashSet.add(new Teclado(obj));
                        break;
                    case "Auricular":
                        this.productoHashSet.add(new Auricular(obj));
                        break;
                    case "Monitor":
                        this.productoHashSet.add(new Monitor(obj));
                        break;
                    case "MousePad":
                        this.productoHashSet.add(new MousePad(obj));
                        break;
                    case "ComputadoraEscritorio":
                        this.productoHashSet.add(new ComputadoraEscritorio(obj));
                        break;
                    case "Notebook":
                        this.productoHashSet.add(new Notebook(obj));
                        break;
                }
            }
        }

    }


    public boolean agregarUsuario(String usuario, String contraseña, String nombre, String gmail) {
        return this.arregloUsuarios.add(new Usuario(usuario, contraseña, nombre, gmail));
    }

    public boolean agregarUsuarioManualmente(String usuario, String contraseña, String nombre, String gmail, TipoUsuario permisos) {
        return this.arregloUsuarios.add(new Usuario(usuario, contraseña, nombre, gmail, permisos));
    }

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

    public Usuario actualizarUsuario(String nombreUsuario){
        for(Usuario usuarios : this.arregloUsuarios){
            if(usuarios.getUsuario().equalsIgnoreCase(nombreUsuario)){
                return usuarios;
            }
        }
        return null;
    }

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

    public String mostrarCarrito(String nombreUsuario){
        StringBuilder contenido = new StringBuilder();
        for(Usuario usuario : this.arregloUsuarios){
            if(nombreUsuario.equalsIgnoreCase(usuario.getNombre())){
                contenido.append(usuario.mostrarProductos());
            }
        }
        return contenido.toString();
    }

    public Usuario hacerLogin(String usuario, String contraseña)throws ExceptionUsuarioInvalido{
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

    public String mostrarUsuarios(){
        StringBuilder contenido = new StringBuilder();
        for(Usuario usuario : this.arregloUsuarios){
            contenido.append(usuario);
        }
        return contenido.toString();
    }

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

    public String verProductos(){
        StringBuilder contenido = new StringBuilder();
        for(Producto productos : this.productoHashSet){
            contenido.append(productos);
        }
        return contenido.toString();
    }

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

    @Override
    public String toString() {
        return "SistemaDeGestion{" +
                "arregloUsuarios=" + arregloUsuarios +
                '}'+"\n";
    }

    /*public JSONArray toJSON() {
        JSONArray usuariosArray = new JSONArray();
        for (Usuario usuario : this.arregloUsuarios) {
            usuariosArray.put(usuario.toJSON());
        }
        return usuariosArray;
    }*/

    public JSONArray toJSON() {
        JSONArray array = new JSONArray();

        // Agregar todos los usuarios
        for (Usuario usuario : this.arregloUsuarios) {
            array.put(usuario.toJSON());
        }

        // Agregar todos los productos
        for (Producto producto : this.productoHashSet) {
            array.put(producto.toJSON());
        }

        return array;
    }



    public JSONArray ticketsToJSON() {
        JSONArray ticketsArray = new JSONArray();
        for (Ticket ticket : this.ticketsGenerados) {
            ticketsArray.put(ticket.toJSON());
        }
        return ticketsArray;
    }

    public Ticket realizarCompra(String nombreUsuario){
        for(Usuario usuario : this.arregloUsuarios){
            if(usuario.getNombre().equalsIgnoreCase(nombreUsuario)){
                // Verificar que tenga productos en el carrito
                if(usuario.getCarritoProductos().getCarrito().isEmpty()){
                    return null;
                }

                // Verificar que tenga método de pago
                if(usuario.getMetodosDePago().isEmpty()){
                    return null;
                }

                // Crear ticket
                Ticket ticket = new Ticket(0, nombreUsuario);
                ticket.agregarProductosDesdeCarrito(usuario.getCarritoProductos());

                // Agregar ticket al sistema
                this.ticketsGenerados.add(ticket);

                // Vaciar carrito
                usuario.vaciarCarrito();

                return ticket;
            }
        }
        return null;
    }
}
