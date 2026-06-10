package com.it.unimol.app;

/**
 * La classe astratta {@code Treno} rappresenta il modello concettuale di base
 * per la gestione di un convoglio ferroviario all'interno del sistema del deposito.
 * <p>
 * Essendo definita come {@code abstract}, non può essere istanziata direttamente,
 * ma funge da classe madre (superclasse) per le categorie specifiche di treni
 * (come Frecciarossa, Intercity e Regionale), garantendo il riuso del codice
 * e l'ereditarietà degli attributi comuni.
 * </p>
 * * @author Alessio
 * @version 1.0
 */

public class Treno {
    private String id;
    private String marca;
    private TipoTreno tipo;
    private String modello;
    private Integer annoProduzione;
    private Integer annoRevisione;
    private Integer numCarrozze;
    private Integer capacita;
    private Integer potenza;


    public Treno(String id, String marca, TipoTreno tipo, String modello, Integer annoProduzione, Integer numCarrozze,
                 Integer annoRevisione, Integer capacita, Integer potenza) {

        this.id = id;
        this.marca = marca;
        this.tipo = tipo;
        this.modello = modello;
        this.annoProduzione = annoProduzione;
        this.numCarrozze = numCarrozze;
        this.annoRevisione = annoRevisione;
        this.capacita = capacita;
        this.potenza = potenza;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Marca: " + marca + " | Modello: " + modello +
                " | Posti: " + capacita + " | Potenza: " + potenza + "kW";
    }


    public TipoTreno getTipo() {
        return tipo;
    }

    public void setTipo(TipoTreno tipo) {
        this.tipo = tipo;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Integer getAnnoProduzione() {
        return annoProduzione;
    }

    public void setAnnoProduzione(Integer annoProduzione) {
        this.annoProduzione = annoProduzione;
    }

    public Integer getAnnoRevisione() {
        return annoRevisione;
    }

    public void setAnnoRevisione(Integer annoRevisione) {
        this.annoRevisione = annoRevisione;
    }

    public Integer getNumCarrozze() {
        return numCarrozze;
    }

    public void setNumCarrozze(Integer numCarrozze) {
        this.numCarrozze = numCarrozze;
    }

    public Integer getCapacita() {
        return capacita;
    }

    public void setCapacita(Integer capacita) {
        this.capacita = capacita;
    }

    public Integer getPotenza() {
        return potenza;
    }

    public void setPotenza(Integer potenza) {
        this.potenza = potenza;
    }



}
