package SharedMobility.sistema;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import SharedMobility.enumerations.Stato;
import SharedMobility.user.Utente;
import SharedMobility.veicoli.Veicoli;

public class Database {
    
    private static HashSet<Veicoli> veicoli = new HashSet<>();
    private static HashSet<Utente> utenti = new HashSet<>();
    
    private static HashMap<Integer, Veicoli> utentiVeicoli = new HashMap<>();

    //Getter
    public static HashSet<Veicoli> getVeicoli() { return veicoli;}
    public static  HashSet<Utente> getUtenti() { return utenti;}
    public static HashMap<Integer, Veicoli> getUtentiVeicoli() { return utentiVeicoli; }
    
    public static void aggiungiVeicoli(Veicoli v){
        if(veicoli.isEmpty()){
            veicoli.add(v);
        }else{
            Iterator<Veicoli> it = veicoli.iterator();
            boolean control = false;
            while(it.hasNext()){
                Veicoli i = it.next();
                if(i.getTarga().equals(v.getTarga()) && i.getTarga() != null){
                    System.out.println("Impossibile aggiungere, mezzo già presente");
                    control = true;
                }    
            }
            if(!control) veicoli.add(v);
        }
    }
    
    public static boolean aggiungiUtente(Utente u){
        if(utenti.isEmpty()){
            utenti.add(u);
            return true;
        }else{
            Iterator<Utente> it = utenti.iterator();
            while(it.hasNext()){
                Utente i = it.next();
                if(i.getCF().equals(u.getCF())){
                    System.out.println("Impossibile aggiungere, utente già presente");
                    return false;
                }    
            }
            utenti.add(u);
            return true;
        }
    }

    public static HashSet<Veicoli> disponibili(){
        if(veicoli.isEmpty()){
            return null;
        }else{
            Iterator<Veicoli> it = veicoli.iterator();
            HashSet<Veicoli> veicoliDisponibili = new HashSet<>();
            while(it.hasNext()){
                Veicoli v = it.next();
                if(v.getStato().equals(Stato.Disponibile)){
                    veicoliDisponibili.add(v);
                }
            }
            return veicoliDisponibili;
        }
    }

    public static void affittaVeicolo(Utente u, int id){
        
    }
        
}
