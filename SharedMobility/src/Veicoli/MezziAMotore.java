package Veicoli;

import enumerations.Alimentazione;

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
        String s = "" + this.getClass();
        String[] split = s.split("\\.");
        return split[split.length-1] + " {" + super.toString() + 
         ", targa: " + getTarga() +
         ", patente richiesta: " + getPatenteRichiesta() + " }";
    }
}
