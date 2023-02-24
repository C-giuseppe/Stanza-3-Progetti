package Veicoli;

import enumerations.Alimentazione;

public class MonopattinoElettrico extends Veicoli{

    public MonopattinoElettrico(String posizione, double tariffa) {
        super(posizione, tariffa);
        al = Alimentazione.Elettrico;
    }
    

}