package veicoli;

import enumerations.Alimentazione;

public class Bicicletta extends Veicolo {

    public Bicicletta(String posizione, double tariffa) {
        super(posizione, tariffa);
        al = Alimentazione.Nessuna;
        super.casco = true;
    }

    @Override
    public String toString() {
        return "Biciclette: { " + super.toString() + " }";
    }
}
