package sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import user.User;
import user.UserBuilder;
import veicoli.Veicolo;

public class Sistema {
    

    public static void registrazione(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Registrazione Utente, inserisci i dati richiesti: ");
        try{
            System.out.print("Inserisci Nome: ");
            String nome = br.readLine();
            System.out.print("Inserisci Cognome: ");
            String cognome = br.readLine();
            System.out.print("Inserisci Codice Fiscale: ");
            String cf = br.readLine();
            System.out.print("Inserisci data di nascita: ");
            SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");
            String dataDiNascita = br.readLine();
            Date date = dateInput.parse(dataDiNascita);
            System.out.print("Inserisci le patenti (se più di una distanziare con space): ");
            String p = br.readLine();
            p = p.toLowerCase();
            String[] split = p.split(" ");
            HashSet<String> patente = new HashSet<>();
            for(String s: split){ patente.add(s); }
            System.out.print("Hai casco? si/no: ");
            String risposta = br.readLine();
            boolean casco = (risposta.equals("si"))?true : false;  
            User u = new UserBuilder().nome(nome).cognome(cognome).cf(cf).dataDiNascita(date)
                .patenti(patente).casco(casco).build();
            boolean control = Database.aggiungiUtente(u);
            if(control) System.out.println("Operazione andata a buon fine");
            else System.out.println("Operazione non riuscita");
        }catch(IOException e){
            System.out.println(e);
        } catch (ParseException e) {
            e.printStackTrace();
        }    
    }

    /**
     * Richiede al database un HashSet<Veicoli>, se non è null lo stampa, caso contrario da un'avvertenza
     */
    public static void ricercaDisponibili(){
        HashSet<Veicolo> veicoliDisponibili = Database.disponibili();
        if(veicoliDisponibili.isEmpty()) System.out.println("Attualmente non sono disponibili veicoli");
        else{
            Iterator<Veicolo> it = veicoliDisponibili.iterator();
            while(it.hasNext()){
                Veicolo v = it.next();
                System.out.println(v.toString());
            }
        }
    }

   /**
     * @param u User
     * stampa i veicoli disponibili attraverso la funzione ricercaDisponibili()
     * se l'utente è maggiorenne chiede quale veicolo vuole affittare e per quanti minuti, se <=  di 4 si interrompe, 
     * caso contrario chiama dal Database la funzione affittaVeicolo se ritorna true operazione riuscita, false non riuscita
     */
     public static void affittaVeicolo(User u){ 
        ricercaDisponibili();
        if(isMaggiorenne(u.getDataDiNascita())){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                System.out.print("Inserisci l'id del veicolo d'affittare: ");
                String line = br.readLine();
                int id = Integer.parseInt(line);
                System.out.print("Inserisci periodo di affitto (in minuti): ");
                line = br.readLine();
                int min = Integer.parseInt(line);
                if(min <= 4){
                    System.out.println("Minuti inseriti sotto la soglia minima, impossibile affittare");
                }else{
                    if(!Database.affittaVeicolo(u, id, min)) System.out.println("Operazione non riuscita");
                    else System.out.println("Operazione riuscita");
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }else{
            System.out.println("Non sei maggiorenne non puoi affittare");
        }
    }

    /**
     * @param dataDiNascita Date
     * @return true se l'utente ha 18 o più, false altrimenti
     */
    private static boolean isMaggiorenne(Date dataDiNascita){
        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate today = date.toInstant().atZone(timeZone).toLocalDate();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String year = getYearFormat.format(dataDiNascita);
        int annoNascita = Integer.parseInt(year);
        int eta = today.getYear() - annoNascita;
        if(eta >= 18) return true;
        else return false;
    }

    /**
     * @param u User
     * @param id, int, rappresenta l'id del veicolo
     */
    public static void restituzione(User u, int id){
        if(Database.resoVeicolo(u, id)) System.out.println("Operazione andata a buon fine");
        else System.out.println("Operazione non riuscita");
    }

}