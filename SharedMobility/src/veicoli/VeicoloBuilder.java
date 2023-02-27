package veicoli;


public class VeicoloBuilder {
    private String targa;
    private double tariffa;

    public VeicoloBuilder(){}

    public VeicoloBuilder targa(String targa){
        this.targa = targa;
        return this;
    }

    public VeicoloBuilder tariffa(double tariffa){
        this.tariffa = tariffa;
        return this;
    }
    
    //Getter
    public String getTarga() { return targa; }
    public double getTariffa() { return tariffa; }

    public Veicolo build(){
        return new Veicolo(this);
    }

}
