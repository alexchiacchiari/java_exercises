package com.it.unimol.app;

public class TrenoSerbatoio extends Treno {

    private Integer capacitaSerbatorio;

    public TrenoSerbatoio(String id,
                          String marca,
                          TipoTreno tipoTreno,
                          String modello,
                          Integer annoProduzione,
                          Integer numCarrozze,
                          Integer annoRevisione,
                          Integer capacita,
                          Integer potenza,
                          Integer capacitaSerbatorio) {
        super(id,
            marca,
            tipoTreno,
            modello,
            annoProduzione,
            numCarrozze,
            annoRevisione,
            capacita,
            potenza);
        this.capacitaSerbatorio = capacitaSerbatorio;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                " | Marca: " + getMarca() +
                " | Modello: " + getModello() +
                " | Posti: " + getCapacita() +
                " | Potenza: " + getPotenza() + " kW" +
                " | Capacita serbatorio: "+capacitaSerbatorio+ " l.";
    }

    public void setCapacitaSerbatorio(Integer capacitaSerbatorio) {
        this.capacitaSerbatorio = capacitaSerbatorio;
    }
    public Integer getCapacitaSerbatorio() {
        return capacitaSerbatorio;
    }

}
