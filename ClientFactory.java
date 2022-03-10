public class ClientFactory {

    public enum TipClient{
        Fizica, Juridica
    }

    public Client creeazaClient(TipClient tipClient, int id, String nume, String adresa, int nrParticipari,
                                int nrLicitatiiCastigate, String dataNastere, double capitalSocial,
                                PersoanaJuridica.Companie companie, int idProdusDorit){
        switch(tipClient) {
            case Fizica:
                return new PersoanaFizica(id, nume, adresa, nrParticipari,
                        nrLicitatiiCastigate, dataNastere, idProdusDorit);

            case Juridica:
                return new PersoanaJuridica(id, nume, adresa, nrParticipari, idProdusDorit,
                        nrLicitatiiCastigate,capitalSocial,companie);

            default:
                return null;
        }
    }

}
