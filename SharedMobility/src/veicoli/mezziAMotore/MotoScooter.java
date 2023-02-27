package veicoli.mezziAMotore;

import veicoli.MezziAMotore;

public class MotoScooter extends MezziAMotore{

    public MotoScooter(String posizione, double tariffa, String targa, String patenteRichiesta) {
        super(posizione, tariffa, targa, patenteRichiesta);
        super.casco = true;
    }
}
