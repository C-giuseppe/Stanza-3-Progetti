package Veicoli.mezziAMotore;

import Veicoli.MezziAMotore;

public class Furgoncini extends MezziAMotore{

    public Furgoncini(String posizione, double tariffa, String targa, String patenteRichiesta) {
        super(posizione, tariffa, targa, patenteRichiesta);
    }
    
    @Override
    public String toString() {
        return "Furgoncini: { " + super.toString() + " }";
    }

}
