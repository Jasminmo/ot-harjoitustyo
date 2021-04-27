package org.otharjoitus.opinnot.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpiskelijaTest {

    Opiskelija opiskelija;

    @Before
    public void setUp() {
        opiskelija = new Opiskelija("1","Malli Oppilas");
    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {
        assertEquals("1", opiskelija.getTunnus());
        assertEquals("Malli Oppilas", opiskelija.getNimi());
    }

    @Test
    public void sahkopostiaVoiPaivittaa() {
        String sposti = "malli.oppilas@sahkoposti.fi";
        opiskelija.setSahkoposti(sposti);
        assertEquals(sposti, opiskelija.getSahkoposti());
    }

    @Test
    public void salasanaaVoiPaivittaa() {
        String sana = "salainen-sana";
        opiskelija.setSalasana(sana);
        assertEquals(sana, opiskelija.getSalasana());
    }

    @Test
    public void equalsToimiiOikein() {
        assertEquals(opiskelija, opiskelija);
        assertNotEquals(opiskelija, null);
        assertNotEquals(opiskelija, "opiskelija");

        Opiskelija toinenOpiskelija = new Opiskelija("1", "Malli Oppilas");
        assertEquals(opiskelija, toinenOpiskelija);
    }

    @Test
    public void toStringToimiiOikein() {
        String mjono = "Opiskelija{tunnus='1', nimi='Malli Oppilas', sahkoposti='', salasana='*****'}";
        assertEquals(opiskelija.toString(), mjono);
    }
}
