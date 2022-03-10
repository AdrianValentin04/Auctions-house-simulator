import java.util.List;
import java.util.Random;

public class Licitatie {

    int id;
    int nrParticipanti;
    int idProdus;
    int nrPasiMaxim;

    static class Builder{

        int id;
        int nrParticipanti;
        int idProdus;
        int nrPasiMaxim;

        public Builder(){
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNrParticipanti() {
            this.nrParticipanti = 0;
            return this;
        }

        public Builder setIdProdus(int idProdus) {
            this.idProdus = idProdus;
            return this;
        }

        public Builder setNrPasiMaxim() {
            this.nrPasiMaxim = 3;
            return this;
        }
    }

    public Licitatie(Builder builder) {
        this.id = builder.id;
        this.nrParticipanti = builder.nrParticipanti;
        this.idProdus = builder.idProdus;
        this.nrPasiMaxim = builder.nrPasiMaxim;
    }

    public Licitatie(){

    }

    public int getId() {
        return id;
    }

    public int getNrParticipanti() {
        return nrParticipanti;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public int getNrPasiMaxim() {
        return nrPasiMaxim;
    }

    public String toString(Produs produs, Client client){
        return "Produsul cu id " + produs.getId() + " a fost vandut lui " + client.getNume() + " pentru suma de "
                + produs.getPretVanzare() + " euro. Licitatia s-a incheiat.";
    }

    public void incepeLicitatia(Lista<Client> clienti, Produs produs){

        Broker broker = new Broker();
        //luam suma minima pentru fiecare pas
        double sumaMinim = produs.pretMinim;
        //se alege numarul de pasi ai licitatiei
        this.nrPasiMaxim = (int)(Math.random() * 3);
        int idClientCastigator = 0;
        double sumaLicitata = 0, sumaMax = sumaMinim;

        //fiecare client alege ce suma e dispus sa liciteze
        for(int i = 0; i < clienti.getLength(); i++){
            clienti.get(i).setSumaLicitat(70 * sumaMinim + Math.random() * 100 * sumaMinim);
        }

        ////fiecare client liciteaza pentru fiecare pas
        for(int i = 0; i < this.nrPasiMaxim; i++){
            for(int j = 0; j < clienti.getLength(); j++){
                if(clienti.get(j).getIdProdusDorit() == produs.id &&
                        broker.aplicaComision(clienti.get(i),clienti.get(i).getSumaLicitat()) > sumaMinim){

                    sumaLicitata = clienti.get(j).liciteaza(sumaMinim);
                }
                //aflam maximul licitat in pasul respectiv
                if(sumaLicitata > sumaMax){
                    sumaMax = sumaLicitata;
                    idClientCastigator = clienti.get(j).id;
                }
            }
            sumaMinim = sumaMax;
        }

        //crestem participarile
        for(int i = 0; i < clienti.getLength(); i++){
            clienti.get(i).nrParticipari ++;
            if(clienti.get(i).getId() == idClientCastigator)
                clienti.get(i).nrLicitatiiCastigate ++;
        }
        produs.pretVanzare = sumaMinim;
        System.out.println(this.toString(produs, clienti.get(idClientCastigator)));
    }
}