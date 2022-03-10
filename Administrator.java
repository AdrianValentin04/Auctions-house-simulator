import java.lang.reflect.Array;
import java.util.ArrayList;

public class Administrator extends Angajat {

    public void adaugaProdus(Produs produs, Lista<Produs> produse){
        produse.adauga(produs);
    }
}
