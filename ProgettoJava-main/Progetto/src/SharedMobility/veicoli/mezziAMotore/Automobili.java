package SharedMobility.veicoli.mezziAMotore;

import SharedMobility.veicoli.MezziAMotore;

public class Automobili extends MezziAMotore{

    public Automobili(String posizione, double tariffa, String targa, String patenteRichiesta) {
        super(posizione, tariffa, targa, patenteRichiesta);

    }

    @Override
    public String toString() {
        return "Automobile: {" + super.toString() + "}";
    }

    

}
