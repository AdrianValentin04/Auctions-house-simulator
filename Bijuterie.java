public class Bijuterie extends Produs {

    String material;
    boolean piatraPretioasa;

    public Bijuterie(String material, boolean piatraPretioasa, int id, String name,
                     double pretVanzare, double pretMinim, int an){

        this.setId(id);
        this.setName(name);
        this.setPretVanzare(pretVanzare);
        this.setPretMinim(pretMinim);
        this.setAn(an);
        this.setMaterial(material);
        this.setPiatraPretioasa(piatraPretioasa);
    }

    String getMaterial(){
        return this.material;
    }

    boolean getPiatraPretioasa(){
        return this.piatraPretioasa;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public void setPiatraPretioasa(boolean piatraPretioasa){
        this.piatraPretioasa = piatraPretioasa;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getName() + " " + this.getMaterial() + " "
                + this.getPiatraPretioasa() + " " + this.getPretMinim();
    }
}

