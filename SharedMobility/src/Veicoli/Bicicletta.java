package Veicoli;

import enumerations.Alimentazione;

public class Bicicletta extends Veicoli {

    private boolean casco; 

    public Bicicletta(String posizione, double tariffa) {
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
