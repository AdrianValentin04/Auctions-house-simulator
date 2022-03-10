import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.ArrayList;

public class Broker extends Angajat{

    public Lista<Client> clienti;

    public Broker(){
        this.clienti = new Lista<>(10);
    }

    //stergem produsul din lista
    public void stergeProdus(Produs produs, Lista<Produs> produse){
        produse.sterge(produs.getId());
    }

    //aplicam comisionul pentru client
    public double aplicaComision(Client client, double suma){
        if(client.getTip() == Client.TipClient.Fizica){
            if(client.nrParticipari < 5){
                suma += suma / 5;
            }
            else{
                suma += suma * 3 / 20;
            }
        }
        else{
            if(client.nrParticipari < 25){
                suma += suma /4;
            }
            else{
                suma += suma /10;
            }
        }
        return suma;
    }

}
