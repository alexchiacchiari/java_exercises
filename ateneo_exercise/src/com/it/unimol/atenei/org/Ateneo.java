package com.it.unimol.atenei.org;

import com.it.unimol.atenei.people.Docente;
import com.it.unimol.atenei.people.Rettore;
import com.it.unimol.atenei.people.Studente;

import java.util.ArrayList;
import java.util.List;

public class Ateneo {
    public static final int MIN_MATRICOLA = 10000;
    public static final int MIN_ID_CORSO = 10;
    private String name;
    private Rettore rettore;
    private List<Studente> studenti;
    private List<Corso> corsi;

    //La classe principale è Ateneo che riceve, come parametro del costruttore, il nome dell'ateneo.
    public Ateneo(String name) {
        this.name = name;
        this.rettore = new Rettore(null, null);
        this.studenti = new ArrayList<>();
        this.corsi = new ArrayList<>();
    }

    //setRettore() che riceve come parametri nome e cognome del rettore.
    public void setRettore(String name, String surname) {
        this.rettore.setName(name);
        this.rettore.setSurname(surname);
    }
    //getRettore() restituisce nome e cognome del rettore concatenati e separati da uno spazio (" ").

    public String getRettore() {
        return this.rettore.getName() + " " + this.rettore.getSurname();
    }

    //Il nome dell'ateneo è leggibile tramite il metodo getNome().
    public String getName() {
        return this.name;
    }

    //immatricola() della classe Ateneo, che riceve il nome ed il cognome dello studente ed inserisce tale studente in ateneo;
    // il metodo restituisce il numero di matricola che è stato assegnato allo studente.
    // I numeri di matricola vengono assegnati in maniera progressiva per ciascun ateneo a partire dal numero 10000.
    // Quindi il primo studente immatricolato ad ogni ateneo avrà matricola 10000.
    public Integer immatricola(String name, String surname) {
        if(studenti.size() <= 1000) {
            if (studenti.isEmpty()) {
                Studente studente = new Studente(MIN_MATRICOLA, name, surname);
                this.studenti.add(studente);
                return studente.getMatricola();
            }
            Studente studente = new Studente(studenti.get(studenti.size() - 1).getMatricola() + 1, name, surname);
            this.studenti.add(studente);
            return studente.getMatricola();
        }

        System.out.println("Massima capienza raggiunta. Non è possibile immatricolare nuovi studenti.");
        return Integer.MAX_VALUE;
    }

    //Per ottenere le informazioni relative ad uno studente si utilizza il metodo getStudente(), sempre della classe Ateneo,
    // che riceve come parametro la matricola e restituisce una stringa composta da
    // numero di matricola, nome e cognome separati da spazi; es. "10000 Giuseppe Verdi".
    public String getStudente(Integer matricola) {
        if(!studenti.isEmpty()) {
            Studente studente = this.studenti.get(matricola - MIN_MATRICOLA);

            return studente.getMatricola()
                    + " "
                    +  studente.getName()
                    + " "
                    +  studente.getSurname();
        }
        return " ";
    }

    //attiva() della classe Ateneo, che riceve come parametri il titolo del corso e il docente titolare ed attiva tale corso in ateneo;
    // il metodo restituisce un intero che corrisponde al codice del corso.
    //I codici vengono assegnati progressivamente a partire da 10. Quindi il primo corso di ciascun ateneo avrà codice 10.
    public Integer attiva(String titolo, String nameDocente, String surnameDocente) {
        if(corsi.size() <= 50) {
            if (corsi.isEmpty()) {
                Corso corso = new Corso(MIN_ID_CORSO, titolo, new Docente(nameDocente, surnameDocente), true);
                this.corsi.add(corso);
                return corso.getId();
            }
            Corso corso = new Corso(corsi.get(corsi.size() - 1).getId() + 1, titolo, new Docente(nameDocente, surnameDocente), true);
            this.corsi.add(corso);
            return corso.getId();
        }

        System.out.println("Massima capienza corsi raggiunta. Non è possibile immatricolare nuovi corsi.");
        return Integer.MAX_VALUE;
    }

    //Per conoscere le informazioni relative ad un corso si usa il metodo getCorso(),
    //che riceve come parametro il codice del corso e restituisce una stringa contenente codice, titolo e docente titolare del corso, separati da virgole;
    // es. "10, Programmazione Object-Oriented, Manuela Flores".
    public String getCorso(Integer idCorso) {
        if(!corsi.isEmpty()) {
            Corso corso = this.corsi.get(idCorso - MIN_ID_CORSO);

            return corso.getId()
                    + ", "
                    +  corso.getName()
                    + " "
                    +  corso.getDocente().getName()
                    + " "
                    + corso.getDocente().getSurname();
        }
        return " ";
    }

    //L'ateneo può registrare gli studenti ai corsi, tramite il metodo registra() che riceve come parametri
    // la matricola dello studente ed il codice del corso. Tale metodo invocherà a sua volta i metodi
    public void registra(Integer matricola, Integer idCorso, Ateneo ateneo) {
        corsi.get(idCorso - MIN_ID_CORSO).iscriviStudente(matricola, ateneo);
        studenti.get(matricola - MIN_MATRICOLA).addToPianoStudi(idCorso, ateneo);
    }

    /*
    Per ottenere l'elenco degli iscritti ad un corso, nella classe Ateneo va realizzato
            * il metodo listaIscritti() che riceve come parametro il codice del corso e
            restituisce una stringa contenente l'elenco degli studenti iscritti a tale corso.
            * Gli studenti devono comparire uno per riga (le righe sono terminate da un a-capo "\\n") secondo il
    secondo il formato descritto al punto 2.
            * Tale metodo, dunque, mediante il codice del corso accederà all'array dei corsi per ottenere quello in oggetto e
            * su tale corso invocherà a sua volta il metodo getIscritti() della classe Corso che, mediante un ciclo,
* costruirà la stringa degli studenti iscritti al corso.
    */

    public void listaIscritti(Integer idCorso) {
            corsi.get(idCorso - MIN_ID_CORSO).getStudenti().
                    forEach(studente -> System.out.println(getStudente(studente.getMatricola())));
    }


    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }
}

