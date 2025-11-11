import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Combos <T>{
    private ArrayList<T>combos;

    public Combos() {
        this.combos = new ArrayList<>();
    }

    public Combos(JSONObject obj) {
        this.combos = new ArrayList<>();
        JSONArray combosArray = obj.getJSONArray("combos");

        for (int i = 0; i < combosArray.length(); i++) {
            JSONObject comboObj = combosArray.getJSONObject(i);
            String tipo = comboObj.getString("tipo");

            switch (tipo) {
                case "Almacenamiento":
                    this.combos.add((T) new Almacenamiento(comboObj));
                    break;
                case "Cpu":
                    this.combos.add((T) new Cpu(comboObj));
                    break;
                case "Gpu":
                    this.combos.add((T) new Gpu(comboObj));
                    break;
                case "MotherBoard":
                    this.combos.add((T) new MotherBoard(comboObj));
                    break;
                case "Ram":
                    this.combos.add((T) new Ram(comboObj));
                    break;
                case "Refrigeracion":
                    this.combos.add((T) new Refrigeracion(comboObj));
                    break;
                case "Fuente":
                    this.combos.add((T) new Fuente(comboObj));
                    break;
                case "Gabinete":
                    this.combos.add((T) new Gabinete(comboObj));
                    break;
                case "Mouse":
                    this.combos.add((T) new Mouse(comboObj));
                    break;
                case "Teclado":
                    this.combos.add((T) new Teclado(comboObj));
                    break;
                case "Auricular":
                    this.combos.add((T) new Auricular(comboObj));
                    break;
                case "Monitor":
                    this.combos.add((T) new Monitor(comboObj));
                    break;
                case "MousePad":
                    this.combos.add((T) new MousePad(comboObj));
                    break;
                case "ComputadoraEscritorio":
                    this.combos.add((T) new ComputadoraEscritorio(comboObj));
                    break;
                case "Notebook":
                    this.combos.add((T) new Notebook(comboObj));
                    break;
            }
        }
    }


        public void agregarCombo(T t){
        combos.add(t);
    }

    public void eliminarCombo(int posicion){
        combos.remove(posicion);
    }

    @Override
    public String toString() {
        return "\nCombos{" +
                "combos=" + combos +
                '}'+"\n";
    }

    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        JSONArray combosArray = new JSONArray();

        for(T combo : this.combos){
            if(combo instanceof Producto){
                combosArray.put(((Producto)combo).toJSON());
            }
        }

        json.put("combos", combosArray);
        return json;
    }
}
