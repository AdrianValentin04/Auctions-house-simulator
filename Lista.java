import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lista<E> {

    E[] tablou;
    int nr;

    public Lista(int dim) throws IllegalArgumentException{
        if(dim <= 0)
            throw new IllegalArgumentException("Mai baga o fisa!");

        tablou = (E[]) new Object[dim];
        nr = 0;
    }

    public void adauga(E x){
        if(tablou.length == nr){
            E[] aux = (E[]) new Object[2 * tablou.length];

            for(int i = 0; i < tablou.length; i++)
                aux[i] = tablou[i];

            tablou = aux;
        }
        tablou[nr] = x;
        nr ++;
    }

    public void sterge(int index){
        for(int i = index; i < nr - 1; i++){
            tablou[i] = tablou[i + 1];
        }
        tablou[nr] = null;
        nr --;
    }

    public void afiseaza(){
        for(int i = 0; i < nr; i++)
            System.out.println(tablou[i].toString());
    }

    public boolean cauta(E x){
        for(int i = 0; i < nr; i++){
            if(tablou[i].equals(x))
                return true;
        }
        return false;
    }

    public int getLength(){
        return this.nr;
    }

    public E get(int i) {
        return tablou[i];
    }
}
