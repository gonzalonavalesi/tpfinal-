import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.desktop.UserSessionEvent;
import java.util.*;

public class SistemaDeGestion {
    private HashSet<Usuario> arregloUsuarios;
    private HashMap <String, Carrito> carritoUsuarios;

    public SistemaDeGestion() {
        this.arregloUsuarios = new HashSet<>();
        this.carritoUsuarios = new HashMap<>();
    }

    public SistemaDeGestion(JSONArray arreglo){
        this.arregloUsuarios = new HashSet<>();

        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject usuario = arreglo.getJSONObject(i);
            this.arregloUsuarios.add(new Usuario(usuario));
        }
    }

    public boolean agregarUsuario(String usuario, String contraseña, String nombre, String gmail) {
        return this.arregloUsuarios.add(new Usuario(usuario, contraseña, nombre, gmail));
    }

    public boolean agregarMetodoDePago(String nombreUsuario, TipoMetodoDePago tipoTarjeta, String numeroTarjeta, int año, int mes, int dia, int cvv) {
        Iterator<Usuario>iterator = this.arregloUsuarios.iterator();
        while(iterator.hasNext()){
            Usuario usuario = iterator.next();
            if(nombreUsuario.equalsIgnoreCase(usuario.getUsuario())){
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

    public boolean agregarComboAlCarrito(HashMap<String, Carrito> carritoUsuarios, String nombreUsuario, Combos combo){
        for(Map.Entry<String, Carrito> entrada : carritoUsuarios.entrySet()){
            if(entrada.getKey().equalsIgnoreCase(nombreUsuario)){
                Carrito carrito = entrada.getValue();
                carrito.agregarAlCarrito(combo);
                return true;
            }
        }
        return false;
    }

    public boolean agregarProductoAlCarrito(HashMap<String, Carrito> carritoUsuarios, String nombreUsuario, Producto p){
        for(Map.Entry<String, Carrito> entrada : carritoUsuarios.entrySet()){
            if(entrada.getKey().equalsIgnoreCase(nombreUsuario)){
                Carrito carrito = entrada.getValue();
                carrito.agregarAlCarrito(p);
                return true;
            }
        }
        return false;
    }

    public String mostrarCarrito(){
        StringBuilder contenido = new StringBuilder();
        Iterator<Map.Entry<String, Carrito>> iterator = this.carritoUsuarios.entrySet().iterator();
        while(iterator.hasNext()){
            contenido.append(iterator.next().getValue());
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

    public HashSet<Usuario> getArregloUsuarios() {
        return arregloUsuarios;
    }

    public void setArregloUsuarios(HashSet<Usuario> arregloUsuarios) {
        this.arregloUsuarios = arregloUsuarios;
    }

    public HashMap<String, Carrito> getCarritoUsuarios() {
        return carritoUsuarios;
    }

    public void setCarritoUsuarios(HashMap<String, Carrito> carritoUsuarios) {
        this.carritoUsuarios = carritoUsuarios;
    }

    @Override
    public String toString() {
        return "SistemaDeGestion{" +
                "arregloUsuarios=" + arregloUsuarios +
                '}'+"\n";
    }

    public JSONArray toJSON() {
        JSONArray usuariosArray = new JSONArray();
        for (Usuario usuario : this.arregloUsuarios) {
            usuariosArray.put(usuario.toJSON());
        }
        return usuariosArray;
    }
}
