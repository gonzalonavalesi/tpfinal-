import org.json.JSONArray;
import org.json.JSONException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SistemaDeGestion sistema = descargarInfo();

        System.out.println(sistema.mostrarUsuarios());
    }

    public static void guardarInfo(JSONArray info){
        JSONUtiles.uploadJson(info);
    }

    public static SistemaDeGestion descargarInfo(){
        SistemaDeGestion sistema;
        try{
            JSONArray lista = new JSONArray(JSONUtiles.downloadJSON());
            sistema = new SistemaDeGestion(lista);
        }catch(JSONException e){
            sistema = new SistemaDeGestion();
            System.out.println("Error, intenta nuevamente");
        }

        return sistema;
    }
}