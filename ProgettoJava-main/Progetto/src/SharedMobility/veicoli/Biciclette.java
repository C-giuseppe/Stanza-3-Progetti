package SharedMobility.veicoli;

import SharedMobility.enumerations.Alimentazione;

public class Biciclette extends Veicoli {

    private boolean casco; 

    public Biciclette(String posizione, double tariffa) {
        super(posizione, tariffa);
        al = Alimentazione.Nessuna;
        casco = true;
    }

    public boolean isCasco() {
        return casco;
    }

    @Override
    public String toString() {
        return "Biciclette: { " + super.toString() +  "Necessita casco? " + casco + "}";
    }

    
    
}
