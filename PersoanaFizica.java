public class PersoanaFizica extends Client {

    String dataNastere;

    public PersoanaFizica(int id, String nume, String adresa, int nrParticipari,
                          int nrLicitatiiCastigate, String dataNastere, int idProdusDorit){
        this.setId(id);
        this.setNume(nume);
        this.setAdresa(adresa);
        this.setNrParticipari(nrParticipari);
        this.setNrLicitatiiCastigate(nrLicitatiiCastigate);
        this.setDataNastere(dataNastere);
        this.setIdProdusDorit(idProdusDorit);
    }

    String getDataNastere() {
        return this.dataNastere;
    }

    public void setDataNastere(String dataNastere){
        this.dataNastere = dataNastere;
    }

    public String toString() {
        return this.getId() + " " + this.getNume() + " " + this.getIdProdusDorit() + " "
                + this.getNrParticipari() + " " + this.getNrLicitatiiCastigate() ;
    }
}
