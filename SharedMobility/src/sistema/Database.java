package sistema;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import enumerations.Alimentazione;
import enumerations.Stato;
import user.User;
import veicoli.MezziAMotore;
import veicoli.Veicolo;



public class Database {
    
    private static HashSet<Veicolo> veicoli = new HashSet<>();
    private static HashSet<User> utenti = new HashSet<>();
    private static HashSet<Veicolo> veicoliDisponibili = new HashSet<>();
    
    private static HashMap<Integer, Veicolo> utentiVeicoli = new HashMap<>();

    //Getter
    public static HashSet<Veicolo> getVeicoli() { return veicoli;}
    public static  HashSet<User> getUtenti() { return utenti;}
    public static HashMap<Integer, Veicolo> getUtentiVeicoli() { return utentiVeicoli; }
    
    /**
     * @param v Veicolo
     * Prende in input un Veicolo, se l'HashSet<Veicoli> è vuoto lo aggiunte direttamente
     * Caso contrario controlla se è un veicolo munito di targa, e se gia presente non aggiunge nulla
     */
    public static void aggiungiVeicoli(Veicolo v){
        if(veicoli.isEmpty()){
            veicoli.add(v);
        }else{
            Iterator<Veicolo> it = veicoli.iterator();
            boolean control = false;
            while(it.hasNext()){
                Veicolo i = it.next();
                if(i.getTarga().equals(v.getTarga()) && i.getTarga() != null){
                    System.out.println("Impossibile aggiungere, mezzo già presente");
                    control = true;
                }    
            }
            if(!control) veicoli.add(v);
        }
    }
    
    /**
     * @param u Utente
     * @return true se l'operazione è andata a buon fine, false altrimenti
     * Prende in input un Utente, controlla se l'HashSet<Utente> è vuoto, in questo caso aggiunge direttamente l'utente
     * Caso contrario controlla se l'utente è gia confrontando i codici fiscali, se già presente non aggiunge nulla
     */
    public static boolean aggiungiUtente(User u){
        if(utenti.isEmpty()){
            utenti.add(u);
            return true;
        }else{
            Iterator<User> it = utenti.iterator();
            while(it.hasNext()){
                User i = it.next();
                if(i.getCF().equals(u.getCF())){
                    System.out.println("Impossibile aggiungere, utente già presente");
                    return false;
                }    
            }
            utenti.add(u);
            return true;
        }
    }

    /**
     * @return un HashSet<Veicoli> che hanno stato Disponibile, se l'HashSet<Veicoli> è vuoto ritorna null
     * Controlla se HashSet<Veicoli> è vuoto o meno, nel primo caso ritorna nulla e finisce
     * Nel secondo caso iterare l'HashSet, ad iterazione controlla lo stato del veicolo se disponibile lo aggiunge 
     * in nuovo HashSet i veicoli disponibili e lo ritorna, se da questa iterazione il nuovo HashSet rimane vuoto ritorna null
     */
    public static HashSet<Veicolo> disponibili(){
        if(veicoli.isEmpty()){
            return null;
        }else{
            Iterator<Veicolo> it = veicoli.iterator();
            veicoliDisponibili.clear();
            while(it.hasNext()){
                Veicolo v = it.next();
                if(v.getStato().equals(Stato.Disponibile)){
                    veicoliDisponibili.add(v);
                }
            }
            if(veicoliDisponibili.isEmpty()) return null;
            else return veicoliDisponibili;
        }
    }

    /**
     * @param u Utente
     * @param id int, rappresenta l'id veicolo
     * @param min int, rappresenta i minuti inseiriti dall'utente
     * @return true se l'operazione è andata a buon fine.
     * false nel caso in cui l'utente ha un affitto in corso, non possiede un casco richiesto dal veicolo, 
     * non possiede la patente richiesta dal veicolo oppure se il credito utente non è sufficiente a coprire il costo
     */
    public static boolean affittaVeicolo(User u, int id, int min){
        if(isAffitto(u)){
            System.out.println("L'utente ha già un affitto in corso, non può affittare altri veicoli al momento");
            return false;
        } 
        Iterator<Veicolo> it = veicoliDisponibili.iterator();
        while(it.hasNext()){
            Veicolo v = it.next();
            if(v.getId() == id){
                double totale = min*v.getTariffa();
                if(!isCasco(u, v)){
                    System.out.println("Il veicolo richiede un casco, non puoi affittarlo sei senza casco");
                    return false;
                }
                if(!isPatente(u, v)){
                    System.out.println("Non hai la patente prevista per poter affittare il veicolo");
                    return false;
                }
                if(totale <= u.getCredito()){
                    u.setCredito(u.getCredito()-totale);
                    utentiVeicoli.put(u.getId(), v);
                    v.setStato(Stato.Affittato);
                    return true;
                }else{
                    System.out.println("Credito insufficiente, impossibile affittare il veicolo");
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @param u Utente
     * @return true se l'utente in questione è presente nella mappa utentiVeicoli, false altrimenti
     */
    private static boolean isAffitto(User u){
        if(utentiVeicoli.containsKey(u.getId())) return true;
        else return false;
    }


    /**
     * @param u Utente
     * @param v veicolo
     * @return true se il veicolo non necessita di casco, oppure se il veicolo lo necessita e l'utente ha il casco, 
     * in caso di mancato casco ritorna false.
     */
    private static boolean isCasco(User u, Veicolo v){
        if(v.isCasco()){
            if(u.isCasco()) return true;
            else return false;
        }else return true;
    }

    /**
     * @param u Utente
     * @param v Veicolo
     * @return true sia se il mezzo non necessita di patente, sia nel caso in cui la necessita e l'utente la possiede.
     * Se il veicolo necessita di una patente e l'utente non la possiede ritorna false
     */
    private static boolean isPatente(User u, Veicolo v){
        if(v.getAl().equals(Alimentazione.Carburante)){
            MezziAMotore mezzo = (MezziAMotore) v;
            HashSet<String> patenti = u.getPatente();
            if(patenti.contains(mezzo.getPatenteRichiesta())) return true;
            else return false;
        }else return true;
    }
        

    /**
     * @param u Utente
     * @param v Veicolo
     * @return true se l'operazione di reso è andata a buon fine, quando l'utente passato è presente nella mappa utentiVeicoli 
     * e il Veicolo passato è in affitto con quel utente.
     * false altrimenti
     * 
     */
    public static boolean resoVeicolo(User u, int id){
        if(utentiVeicoli.containsKey(u.getId())){
            Veicolo k = utentiVeicoli.get(u.getId());
            if(k.getId() == id){
                utentiVeicoli.remove(u.getId());
                k.setStato(Stato.Disponibile);
                return true;
            }else{
                System.out.println("Il veicolo da restituire non è assocciato all'utente");
                return false;
            }
        }else{
            System.out.println("L'utente non è assocciato a nessun veicolo, impossibile attuare un reso");
            return false;
        }
    }
}