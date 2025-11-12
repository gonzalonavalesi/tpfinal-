package Clases;

import Interfaces.ObtenerTotal;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Combos <T> extends Producto implements ObtenerTotal {
    //ATREIBUTOS
    private ArrayList<T>combos;

    //CONSTRUCTORES
    public Combos(double precio, String marca, String modelo) {
        super(precio, marca, modelo);
        this.combos = new ArrayList<>();
    }

    public Combos(JSONObject obj) {
        super(obj);
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

//METODOS
    public void agregarCombo(T t){
        combos.add(t);
    }

    @Override
    public double GetTotal() {
        double valorTotal = 0;
        for (T t : combos) {
            if (t instanceof Almacenamiento) {
                valorTotal += ((Almacenamiento) t).getPrecio();
            }
            else if (t instanceof Cpu) {
                valorTotal += ((Cpu) t).getPrecio();
            }
            else if (t instanceof Gpu) {
                valorTotal += ((Gpu) t).getPrecio();
            }
            else if (t instanceof MotherBoard) {
                valorTotal += ((MotherBoard) t).getPrecio();
            }
            else if (t instanceof Ram) {
                valorTotal += ((Ram) t).getPrecio();
            }
            else if (t instanceof Refrigeracion) {
                valorTotal += ((Refrigeracion) t).getPrecio();
            }
            else if (t instanceof Fuente) {
                valorTotal += ((Fuente) t).getPrecio();
            }
            else if (t instanceof Gabinete) {
                valorTotal += ((Gabinete) t).getPrecio();
            }
            else if (t instanceof Mouse) {
                valorTotal += ((Mouse) t).getPrecio();
            }
            else if (t instanceof Teclado) {
                valorTotal += ((Teclado) t).getPrecio();
            }
            else if (t instanceof Auricular) {
                valorTotal += ((Auricular) t).getPrecio();
            }
            else if (t instanceof Monitor) {
                valorTotal += ((Monitor) t).getPrecio();
            }
            else if (t instanceof MousePad) {
                valorTotal += ((MousePad) t).getPrecio();
            }
            else if (t instanceof ComputadoraEscritorio) {
                valorTotal += ((ComputadoraEscritorio) t).GetTotal();
            }
            else if (t instanceof Notebook) {
                valorTotal += ((Notebook) t).getPrecio();
            }
        }
        return valorTotal;
    }

    public void eliminarCombo(int posicion){
        combos.remove(posicion);
    }

    @Override
    public String toString() {
        return "\nClases.Combos{" +
                "combos=" + combos +
                '}'+"\n";
    }

    public JSONObject toJSON(){
        JSONObject jsonDelSuper = super.toJSON();
        jsonDelSuper.put("tipo", "Clases.Combos");
        JSONObject jsonHijo = new JSONObject();
        JSONArray combosArray = new JSONArray();

        for(T combo : this.combos){
            if(combo instanceof Producto){
                combosArray.put(((Producto)combo).toJSON());
            }
        }

        jsonHijo.put("combos", combosArray);
        return jsonHijo;
    }
}
