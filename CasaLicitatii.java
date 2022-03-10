import java.util.List;

public class CasaLicitatii {

    public Lista<Produs> produse;
    public Lista<Client> clienti;
    public Lista<Licitatie> licitatii;
    public Lista<Broker> brokeri;

    public CasaLicitatii(){
        this.produse = new Lista<>(10);
        this.clienti = new Lista<>(30);
        this.licitatii = new Lista<>(12);
    }

    public void adaugaClient(Client client, Lista<Client> clienti){
        clienti.adauga(client);
    }

    public void alegeProdus(){
        for(int i = 0; i < clienti.getLength(); i++){
            clienti.get(i).idProdusDorit = (int) (Math.random() * produse.getLength());
        }
    }






}
