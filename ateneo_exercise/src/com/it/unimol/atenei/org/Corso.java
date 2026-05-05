package com.it.unimol.atenei.org;

import com.it.unimol.atenei.people.Docente;
import com.it.unimol.atenei.people.Studente;

import java.util.ArrayList;
import java.util.List;

public class Corso {

    private Integer id;
    private String name;
    private Docente docente;
    private Boolean active;
    private List<Studente> studenti;

    public Corso(Integer id, String name, Docente docente, Boolean active) {
        this.id = id;
        this.name = name;
        this.docente = docente;
        this.active = active;
        this.studenti = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    //iscriviStudente() della classe Corso, che riceve come parametro uno studente
    public void iscriviStudente(Integer matricola, Ateneo ateneo) {
        this.studenti.add(ateneo.getStudenti().get(matricola - Ateneo.MIN_MATRICOLA));
    }

}
