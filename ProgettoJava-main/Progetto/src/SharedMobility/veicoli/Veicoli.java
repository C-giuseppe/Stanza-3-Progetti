package SharedMobility.veicoli;

import SharedMobility.enumerations.Alimentazione;
import SharedMobility.enumerations.Stato;

public class  Veicoli {
    protected int id;
    private static int cont = 0;
    protected String posizione;
    
    protected Stato stato; 
    protected String targa;
    protected Alimentazione al;

    protected double tariffa;

    public Veicoli(String posizione, double tariffa) {
        this.id = cont++;
        this.posizione = posizione;
        stato = Stato.Disponibile;
        targa = null;
        this.tariffa = tariffa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Alimentazione getAl() {
        return al;
    }

    public String getTarga(){
        return targa;
    }    
    
    public double getTariffa() {
        return tariffa;
    }
    
    @Override
    public String toString(){
        return 
         "id: " + getId() +
         ", posizione: " + getPosizione() +
         ", alimentazione: " + getAl() +
         ", tariffa: " + getTariffa();
    }

}
