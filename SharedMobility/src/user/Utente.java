package user;

import java.util.Date;
import java.util.HashSet;

public class Utente {
    private String nome, cognome, CF;
    private Date dataDiNascita;
    private int id;
    private static int cont;
    private HashSet<String> patente;
    private boolean casco;
    private double credito;
    
    public Utente(String nome, String cognome, String cF, Date dataDiNascita, HashSet<String> patente, boolean casco) {
        id = cont++;
        this.nome = nome;
        this.cognome = cognome;
        CF = cF;
        this.dataDiNascita = dataDiNascita;
        this.patente = patente;
        this.casco = casco;
        credito = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String cF) {
        CF = cF;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashSet<String> getPatente() {
        return patente;
    }

    public void setPatente(HashSet<String> patente) {
        this.patente = patente;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }
    
    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Utente [nome=" + nome + ", cognome=" + cognome + ", CF=" + CF + ", dataDiNascita=" + dataDiNascita
                + ", id=" + id + ", patente=" + patente + ", casco=" + casco + ", credito=" + credito + "]";
    }    
}

