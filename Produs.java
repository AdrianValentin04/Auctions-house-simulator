public class Produs {

    int id;
    String nume;
    double pretVanzare;
    double pretMinim;
    int an;

    public Produs(){}

    int getId(){
        return this.id;
    }

    String getName(){
        return this.nume;
    }

    double getPretVanzare(){
        return this.pretVanzare;
    }

    double getPretMinim(){
        return this.pretMinim;
    }

    int getAn(){
        return this.an;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.nume = name;
    }

    public void setPretVanzare(double pretVanzare){
        this.pretVanzare = pretVanzare;
    }

    public void setPretMinim(double pretMinim){
        this.pretMinim = pretMinim;
    }

    public void setAn(int an){
        this.an = an;
    }

    public String toString(){
        return this.getId() + " " + this.getName();
    }

}
