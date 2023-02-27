package veicoli;

import enumerations.Alimentazione;

public class MonopattinoElettrico extends Veicolo{

    public MonopattinoElettrico(String posizione, double tariffa) {
        super(posizione, tariffa);
        al = Alimentazione.Elettrico;
    }

    @Override
    public String toString() {
        return "MonopattinoElettrico: { " + super.toString() + " }";
    }

}