public class Client {

    public enum TipClient{
        Fizica, Juridica
    }

    int id;
    String nume;
    String adresa;
    int nrParticipari;
    int nrLicitatiiCastigate;
    int idProdusDorit;
    TipClient tip;
    double sumaLicitat;

    public void setId(int id){
        this.id = id;
    }

    public void setNume(String nume){
        this.nume = nume;
    }

    public void setAdresa(String adresa){
        this.adresa = adresa;
    }

    public void setNrParticipari(int nrParticipari){
        this.nrParticipari = nrParticipari;
    }

    public void setNrLicitatiiCastigate(int nrLicitatiiCastigate){
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
    }

    public void setIdProdusDorit(int idProdusDorit){this.idProdusDorit = idProdusDorit;}

    public void setSumaLicitat(double sumaLicitat){this.sumaLicitat = sumaLicitat;}

    int getId(){
        return this.id;
    }

    String getNume(){
        return this.nume;
    }

    String getAdresa(){
        return this.adresa;
    }

    int getNrParticipari(){
        return this.nrParticipari;
    }

    int getNrLicitatiiCastigate(){
        return this.nrLicitatiiCastigate;
    }

    int getIdProdusDorit(){return this.idProdusDorit;}

    TipClient getTip(){return this.tip;}

    double getSumaLicitat(){return this.sumaLicitat;}

    public double liciteaza(double sumaMinima){
        return sumaMinima + Math.random() * 2 * sumaMinima;
    }

    public String toString(){
        return this.getId() + " " + this.getNume() + " " + this.getNrParticipari()
                + " " + this.getIdProdusDorit() + this.nrLicitatiiCastigate;
    }

}
