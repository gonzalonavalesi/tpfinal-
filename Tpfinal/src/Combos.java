import java.util.ArrayList;

public class Combos <T>{
    private ArrayList<T>combos;

    public Combos() {
        this.combos = new ArrayList<>();
    }

    public void agregarCombo(T t){
        combos.add(t);
    }

    public void eliminarCombo(int posicion){
        combos.remove(posicion);
    }

    @Override
    public String toString() {
        return "Combos{" +
                "combos=" + combos +
                '}';
    }
}
