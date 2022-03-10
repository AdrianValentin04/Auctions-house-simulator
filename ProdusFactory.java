public class ProdusFactory {

    public enum TipProdus{
        tablou, mobila, bijuterie
    }

    public Produs creeazaProdus(int id, String name, double pretVanzare, double pretMinim, int an,
                                String tip, String material, String numePictor, Tablou.Culori c,
                                String ma, boolean piatraPretioasa, TipProdus tipProdus){
        switch(tipProdus) {
            case tablou:
                return new Tablou(numePictor, c, id, name, pretVanzare, pretMinim, an);

            case mobila:
                return new Mobila(tip, material , id, name, pretVanzare, pretMinim, an);

            case bijuterie:
                return new Bijuterie(ma, piatraPretioasa , id, name, pretVanzare, pretMinim, an);

            default:
                return null;
        }
    }
}
