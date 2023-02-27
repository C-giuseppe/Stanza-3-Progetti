package veicoli;

import enumerations.Alimentazione;
import enumerations.Stato;

public class  Veicolo2 {
    protected int id;
    private static int cont = 0;
    
    protected Stato stato; 
    protected String targa;
    protected Alimentazione al;

    protected double tariffa;
    protected boolean casco;

    public Veicolo2(VeicoloBuilder vb) {
        this.id = cont++;
        targa = vb.getTarga();
        tariffa = vb.getTariffa();
        stato = Stato.Disponibile;
        casco = false;
    }

    //Getter
    public int getId() { return id; }
    public boolean isCasco() { return casco; }
    public Stato getStato() { return stato;}
    public Alimentazione getAl() { return al; }
    public String getTarga(){ return targa; }    
    public double getTariffa() { return tariffa;}

    //Setter
    public void setId(int id) { this.id = id; }
    public void setStato(Stato stato) { this.stato = stato;}

    @Override
    public String toString(){
        return 
         "id: " + getId() +
         ", alimentazione: " + getAl() +
         ", tariffa: " + getTariffa() +
         ", casco: " + isCasco();
    }
}