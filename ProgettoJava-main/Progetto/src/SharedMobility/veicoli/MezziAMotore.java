package SharedMobility.veicoli;

import SharedMobility.enumerations.Alimentazione;

public class MezziAMotore extends Veicoli{
    
    protected String  patenteRichiesta;

    public MezziAMotore(String posizione, double tariffa, String targa, String patenteRichiesta) {
        super(posizione, tariffa);
        super.targa = targa;
        this.patenteRichiesta = patenteRichiesta;
        al = Alimentazione.Carburante;
    }

    public String getPatenteRichiesta() {
        return patenteRichiesta;
    }

    @Override
    public String toString(){
        return super.toString() + 
         ", targa: " + getTarga() +
         ", patente richiesta: " + getPatenteRichiesta();
    }
}
