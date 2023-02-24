package sistema;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import Veicoli.Veicoli;
import user.Utente;

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
            Utente u = new Utente(nome, cognome, cf, date, patente, casco);
            boolean control = Database.aggiungiUtente(u);
            if(control) System.out.println("Operazione andata a buon fine");
            else System.out.println("Operazione non riuscita");
        }catch(Exception e){
            System.out.println(e);
        }    
    }

    public static void ricercaDisponibili(){
        HashSet<Veicoli> veicoliDisponibili = Database.disponibili();
        if(veicoliDisponibili.isEmpty()) System.out.println("Attualmente non sono disponibili veicoli");
        else{
            Iterator<Veicoli> it = veicoliDisponibili.iterator();
            while(it.hasNext()){
                Veicoli v = it.next();
                System.out.println(v.toString());
            }
        }
    }

    public static void affittaVeicolo(Utente u){
        ricercaDisponibili();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Inserisci l'id del veicolo d'affittare: ");
            String line = br.readLine();
            int id = Integer.parseInt(line);
            Database.affittaVeicolo(u, id);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}