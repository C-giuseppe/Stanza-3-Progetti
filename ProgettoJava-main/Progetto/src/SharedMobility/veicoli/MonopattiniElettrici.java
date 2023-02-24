package SharedMobility.veicoli;

import SharedMobility.enumerations.Alimentazione;

public class MonopattiniElettrici extends Veicoli{

    public MonopattiniElettrici(String posizione, double tariffa) {
        super(posizione, tariffa);
        al = Alimentazione.Elettrico;
    }
    

}
