package veicoli;

import enumerations.Alimentazione;
import enumerations.Stato;

public class  Veicolo {
    protected int id;
    private static int cont = 0;
    protected String posizione;
    
    protected Stato stato; 
    protected String targa;
    protected Alimentazione al;

    protected double tariffa;
    protected boolean casco;

    public Veicolo(String posizione, double tariffa) {
        this.id = cont++;
        this.posizione = posizione;
        stato = Stato.Disponibile;
        targa = null;
        this.tariffa = tariffa;
        casco = false;
    }

    public Veicolo(VeicoloBuilder vb) {
        this.id = cont++;
        targa = vb.getTarga();
        tariffa = vb.getTariffa();
        stato = Stato.Disponibile;
        casco = false;
    }

    //Getter
    public int getId() { return id; }
    public boolean isCasco() { return casco; }
    public String getPosizione() { return posizione; }
    public Stato getStato() { return stato;}
    public Alimentazione getAl() { return al; }
    public String getTarga(){ return targa; }    
    public double getTariffa() { return tariffa;}

    //Setter
    public void setId(int id) { this.id = id; }
    public void setPosizione(String posizione) { this.posizione = posizione; }
    public void setStato(Stato stato) { this.stato = stato;}

    @Override
    public String toString(){
        return 
         "id: " + getId() +
         ", posizione: " + getPosizione() +
         ", alimentazione: " + getAl() +
         ", tariffa: " + getTariffa() +
         ", casco: " + isCasco();
    }
}