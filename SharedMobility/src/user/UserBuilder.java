package user;

import java.util.Date;
import java.util.HashSet;

public class UserBuilder {
    private String nome, cognome, cf;
    private Date dataDiNascita;
    private HashSet<String> patenti;
    private boolean casco;
    
    public UserBuilder(){}

    public UserBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public UserBuilder cognome(String cognome){
        this.cognome = cognome;
        return this;
    }

    public UserBuilder cf(String cf){
        this.cf = cf;
        return this;
    }

    public UserBuilder dataDiNascita(Date dataDiNascita){
        this.dataDiNascita = dataDiNascita;
        return this;
    }

    public UserBuilder patenti(HashSet<String> patenti){
        this.patenti = patenti;
        return this;
    }

    public UserBuilder casco(boolean casco){
        this.casco = casco;
        return this;
    }

    public User build(){
        return new User(this);
    }

    //Getter
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getCf() { return cf; }
    public Date getDataDiNascita() { return dataDiNascita; }
    public HashSet<String> getPatenti() { return patenti; }
    public boolean isCasco() { return casco; }
}
