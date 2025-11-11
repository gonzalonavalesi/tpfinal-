import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JSONUtiles {

    private static final String archivoUsuarios = "usuarios";
    private static final String usuarioLogueaado = "usuarioLogueado";
    private static final String archivoTickets = "tickets";

    public static void uploadJson(JSONArray arreglo){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archivoUsuarios+".json"));
            salida.write(arreglo.toString(4));
            salida.flush();
            salida.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void uploadJson(JSONObject objeto){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(usuarioLogueaado+".json"));
            salida.write(objeto.toString(4));
            salida.flush();
            salida.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String downloadJSONUsuario(){
        StringBuilder contenido = new StringBuilder();
        String linea= "";
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(usuarioLogueaado+".json"));
            while((linea = entrada.readLine()) != null){
                contenido.append(linea);
            }
            entrada.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

    public static String downloadJSON(){
        StringBuilder contenido = new StringBuilder();
        String linea= "";
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivoUsuarios+".json"));
            while((linea = entrada.readLine()) != null){
                contenido.append(linea);
            }
            entrada.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

    public static void uploadJsonTickets(JSONArray arreglo){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archivoTickets+".json"));
            salida.write(arreglo.toString(4));
            salida.flush();
            salida.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
