package com.it.unimol.atenei.people;

import com.it.unimol.atenei.org.Ateneo;
import com.it.unimol.atenei.org.Corso;

import java.util.ArrayList;
import java.util.List;

public class Studente extends Persona {
    private Integer matricola;
    private List<Corso> corsi;

    public Studente(Integer matricola, String name, String surname) {
        super(name, surname);
        this.matricola = matricola;
        this.corsi = new ArrayList<>();
    }

    public Integer getMatricola() {
        return this.matricola;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    //addToPianoStudi() della classe Studente, che riceve come parametro un corso
    public void addToPianoStudi(Integer idCorso, Ateneo ateneo) {
        this.corsi.add(ateneo.getCorsi().get(idCorso - Ateneo.MIN_ID_CORSO));
    }
}
