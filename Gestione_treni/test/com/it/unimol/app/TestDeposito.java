package com.it.unimol.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeposito {

    private Deposito deposito;

    @Before
    public void setUp() {
        this.deposito = new Deposito();
        this.deposito.aggiungiTreno(new Treno("1a",
                "x",
                TipoTreno.dalCodice(1),
                "y",
                2025,
                500,
                2026,
                300,
                1000));
        this.deposito.aggiungiTreno(new TrenoSerbatoio("1b",
                "z",
                TipoTreno.dalCodice(2),
                "y",
                2025,
                500,
                2026,
                300,
                1000,
                500
        ));
    }

    @Test
    public void testCostruttoreEGetters() {
        Treno freccia = deposito.getDeposito().get(0);
        Treno intercity = deposito.getDeposito().get(1);
        assertEquals("x", freccia.getMarca());
        assertEquals(Integer.valueOf(2025), intercity.getAnnoProduzione());
    }

    @Test
    public void testRicercaId() {
        Treno freccia = deposito.getDeposito().get(0);
        assertEquals(freccia, deposito.ricercaId("1a"));
        Treno intercity = deposito.getDeposito().get(1);
        assertEquals(intercity, deposito.ricercaId("1b"));
    }
}
