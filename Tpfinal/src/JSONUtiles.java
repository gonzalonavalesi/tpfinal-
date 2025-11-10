import org.json.JSONArray;

import java.io.*;

public class JSONUtiles {

    private static final String archivoUsuarios = "usuarios";

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

}
