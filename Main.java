import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //cateva obiecte de care avem nevoie
        CasaLicitatii casa = new CasaLicitatii();
        Licitatie licitatie = new Licitatie();
        Scanner scanner = new Scanner(System.in);

        ProdusFactory factoryProdus = new ProdusFactory();
        ClientFactory factoryClient = new ClientFactory();

        Administrator administrator = new Administrator();
        Broker broker = new Broker();

        String s = scanner.next();
        Produs produs = new Produs();
        Client client = new Client();

        //Citim produse si le adaugam in lista
        while(!s.equals("stop")){
            int id = scanner.nextInt();
            String name = scanner.next();
            int pretMinim = scanner.nextInt();
            int an = scanner.nextInt();
            String tipProdus =  scanner.next();

            switch(tipProdus){
                case "Tablou":
                    String pictor = scanner.next();
                    String culori = scanner.next();
                    if(culori.equals("ulei")){
                        produs = factoryProdus.creeazaProdus(id, name, 0, pretMinim, an,
                                "tip", " material", pictor, Tablou.Culori.ulei,
                                "material", true, ProdusFactory.TipProdus.tablou);
                    }
                    else if(culori.equals("tempera")){
                        produs = factoryProdus.creeazaProdus(id, name, 0, pretMinim, an,
                                "tip", " material", pictor, Tablou.Culori.tempera,
                                "material", true, ProdusFactory.TipProdus.tablou);
                    }
                    else{
                        produs = factoryProdus.creeazaProdus(id, name, 0, pretMinim, an,
                                "tip", " material", pictor, Tablou.Culori.acrilic,
                                "material", true, ProdusFactory.TipProdus.tablou);
                    }
                    break;

                case "Mobila":
                    String tip = scanner.next();
                    String material = scanner.next();
                    produs = factoryProdus.creeazaProdus(id, name, 0, pretMinim, an,
                            tip, material, "pictor", Tablou.Culori.ulei,
                            "material", true, ProdusFactory.TipProdus.mobila);
                    break;

                case "Bijuterie":
                    material = scanner.next();
                    boolean piatra = scanner.nextBoolean();
                    produs = factoryProdus.creeazaProdus(id, name, 0, pretMinim, an,
                            "tip", " material", "pictor", Tablou.Culori.ulei,
                            material, piatra, ProdusFactory.TipProdus.bijuterie);
                    break;

            }
            administrator.adaugaProdus(produs, casa.produse);
            s = scanner.next();
        }
        s = scanner.next();

        //Citim clienti si ii adaugam in lista
        while(!s.equals("stop")){
            int id = scanner.nextInt();
            String nume = scanner.next();
            String adresa = scanner.next();
            String tipClient = scanner.next();

            switch (tipClient) {
                case "Fizica" -> {
                    String dataNastere = scanner.next();
                    client = factoryClient.creeazaClient(ClientFactory.TipClient.Fizica, id, nume, adresa,
                            0, 0, dataNastere, 0.0,
                            PersoanaJuridica.Companie.SRL, 0);
                    client.tip = Client.TipClient.Fizica;
                }
                case "Juridica" -> {
                    int capital = scanner.nextInt();
                    String companie = scanner.next();
                    if (companie.equals("SRL")) {
                        client = factoryClient.creeazaClient(ClientFactory.TipClient.Juridica, id, nume, adresa,
                                0, 0, "nu conteaza", capital,
                                PersoanaJuridica.Companie.SRL, 0);
                    } else {
                        client = factoryClient.creeazaClient(ClientFactory.TipClient.Juridica, id, nume, adresa,
                                0, 0, "nu conteaza", capital,
                                PersoanaJuridica.Companie.SA, 0);
                    }
                    client.tip = Client.TipClient.Juridica;
                }
            }
            casa.adaugaClient(client, casa.clienti);
            s = scanner.next();
        }

        //repetam licitatiile pana cand se vand toate produsele
        while(casa.produse.getLength() != 0){
        //fiecare client alege produsul
            casa.alegeProdus();
            int[] listaAparitii = new int[casa.produse.getLength()];
        //vedem care produs e cel mai dorit
            for(int i = 0; i < casa.clienti.getLength(); i++){
                listaAparitii[casa.clienti.get(i).getIdProdusDorit()] ++;
            }

            int max = 0, idMax = 0, i;

            for(i = 0; i < listaAparitii.length; i++){
                if(max < listaAparitii[i]){
                    max = listaAparitii[i];
                    idMax = i;
                }
            }
            //incepem licitatia
            licitatie.incepeLicitatia(casa.clienti, casa.produse.get(idMax));
            //stergem obiectul care a fost cumparat
            broker.stergeProdus(casa.produse.get(idMax), casa.produse);
            //schimbam id urile produselor ca sa corespunda din nou cu pozitia lor in lista
            for(i = 0; i < casa.produse.getLength(); i++){
                casa.produse.get(i).id = i;
            }
        }
    }
}
