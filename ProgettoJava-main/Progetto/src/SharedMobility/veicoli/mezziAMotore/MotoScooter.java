package SharedMobility.veicoli.mezziAMotore;

import SharedMobility.veicoli.MezziAMotore;

public class MotoScooter extends MezziAMotore{

    public MotoScooter(String posizione, double tariffa, String targa, String patenteRichiesta) {
        super(posizione, tariffa, targa, patenteRichiesta);
    }

    @Override
    public String toString() {
        return "MotoScooter: { " + super.toString() + " }";
    }

}
