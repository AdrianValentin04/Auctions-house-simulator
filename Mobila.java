public class Mobila extends Produs {

    String tip;
    String material;

    public Mobila(String tip, String material, int id, String name, double pretVanzare, double pretMinim, int an){
       this.setId(id);
       this.setName(name);
       this.setPretVanzare(pretVanzare);
       this.setPretMinim(pretMinim);
       this.setAn(an);
       this.setTip(tip);
       this.setMaterial(material);
    }

    public void setTip(String tip){
        this.tip = tip;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    String getTip(){
        return this.tip;
    }

    String getMaterial(){
        return this.material;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getName() + " " + this.getMaterial() + " " + this.getPretMinim();
    }
}
