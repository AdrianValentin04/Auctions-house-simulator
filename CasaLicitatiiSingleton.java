public class CasaLicitatiiSingleton {

    private static CasaLicitatii casa = new CasaLicitatii();

    private CasaLicitatiiSingleton(){

    }

    public static CasaLicitatii getCasa(){
        return casa;
    }
}
