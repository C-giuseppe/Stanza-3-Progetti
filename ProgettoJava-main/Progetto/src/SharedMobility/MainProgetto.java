package SharedMobility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

//import java.util.HashSet;
//import java.util.Iterator;

import SharedMobility.sistema.Database;
import SharedMobility.sistema.Sistema;
import SharedMobility.user.Utente;
import SharedMobility.veicoli.mezziAMotore.Automobili;
import SharedMobility.veicoli.mezziAMotore.MotoScooter;

public class MainProgetto { 
    public static void main(String[] args) {
        Database.aggiungiVeicoli(new Automobili("Catania", 2,"AW234RF", "B"));
        Database.aggiungiVeicoli(new MotoScooter("Napoli", 2, "QW475KJ", "A1"));

 /*     Sistema.registrazione();
        HashSet<Utente> utenti = Database.getUtenti();
        Iterator<Utente> it = utenti.iterator();
        if(utenti.isEmpty()) System.out.println("Vuoto");
        else{
            while(it.hasNext()){
                Utente i = it.next();
                System.out.println(i.toString());
            }
        }*/

        //Sistema.ricercaDisponibili();
        SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");
        String dataDiNascita = "2000-08-16";
        Date date = null;
        try {
            date = dateInput.parse(dataDiNascita);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HashSet<String> patenti = new HashSet<>();
        patenti.add("A1");
        patenti.add("B");
        Utente u = new Utente("Luca", "Rossi", "DKKEFJEIF", date, patenti, false);
        Sistema.affittaVeicolo(u);
        

    }
}
