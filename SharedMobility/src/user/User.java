package user;

import java.util.Date;
import java.util.HashSet;

import interfacce.Observable;
import interfacce.Observer;

public class User implements Observer{
    private String nome, cognome, cf;
    private Date dataDiNascita;
    private int id;
    private static int cont;
    private HashSet<String> patenti;
    private boolean casco;
    private double credito;
    
/*  public User(String nome, String cognome, String cF, Date dataDiNascita, HashSet<String> patente, boolean casco) {
        id = cont++;
        this.nome = nome;
        this.cognome = cognome;
        cf = cF;
        this.dataDiNascita = dataDiNascita;
        this.patenti = patente;
        this.casco = casco;
        credito = 0;
    }*/

    public User(UserBuilder ub){
        id = cont++;
        nome = ub.getNome();
        cognome = ub.getCognome();
        cf = ub.getCf();
        dataDiNascita = ub.getDataDiNascita();
        patenti = ub.getPatenti();
        casco = ub.isCasco();
        credito = 0;
    }

    //Getter
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getCF() { return cf; }
    public Date getDataDiNascita() { return dataDiNascita; }
    public int getId() { return id; }
    public HashSet<String> getPatente() { return patenti; }
    public boolean isCasco() { return casco; }
    public double getCredito() { return credito; }

    //Setter
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setCF(String cF) { cf = cF; }
    public void setDataDiNascita(Date dataDiNascita) { this.dataDiNascita = dataDiNascita; } 
    public void setPatente(HashSet<String> patente) { this.patenti = patente; }
    public void setCasco(boolean casco) { this.casco = casco; }
    public void setCredito(double credito) { this.credito = credito; }

    @Override
    public String toString() {
        return "Utente [ id: " + id + ", nome: " + nome + ", cognome: " + cognome + ", CF: " + cf + ", dataDiNascita: " + dataDiNascita
            + ", patente: " + patenti + ", casco: " + casco + ", credito: " + credito + "]";
    }

    @Override
    public void notifyMe(Observable o, String message) {
        throw new UnsupportedOperationException("Unimplemented method 'notifyMe'");
    }    
}