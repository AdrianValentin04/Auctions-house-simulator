public class Tablou extends Produs {

    String numePictor;
    Culori culori;

    public enum Culori{
        ulei, tempera, acrilic
    }

    public Tablou(String numePictor, Culori c, int id, String name, double pretVanzare, double pretMinim, int an){
        this.setId(id);
        this.setName(name);
        this.setPretVanzare(pretVanzare);
        this.setPretMinim(pretMinim);
        this.setAn(an);
        this.setNumePictor(numePictor);
        this.setCulori(c);
    }

    public void setNumePictor(String numePictor){
        this.numePictor = numePictor;
    }

    public void setCulori(Culori c){
        this.culori = c;
    }

    String getNumePictor(){
        return numePictor;
    }

    Culori getCulori(){
        return culori;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getName() + " " + this.getNumePictor() + " "
                + this.getCulori() + " " + this.getPretMinim();
    }
}
