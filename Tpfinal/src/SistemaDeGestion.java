import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SistemaDeGestion {
    private HashSet<Usuario> arregloUsuarios;

    public SistemaDeGestion() {
        this.arregloUsuarios = new HashSet<>();
    }

    public SistemaDeGestion(JSONArray arreglo){
        this.arregloUsuarios = new HashSet<>();

        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject usuario = arreglo.getJSONObject(i);
            this.arregloUsuarios.add(new Usuario(usuario));
        }
    }

    public boolean agregarUsuario(String usuario, String contraseña, String nombre, String gmail, TipoUsuario tipoUsuario) {
        return this.arregloUsuarios.add(new Usuario(usuario, contraseña, nombre, gmail, tipoUsuario));
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
