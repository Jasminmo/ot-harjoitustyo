package org.ot_harjoitus.opinnot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpiskelijaTest {

    Opiskelija opiskelija;

    @Before
    public void setUp() {
        opiskelija = new Opiskelija(1,"Malli Oppilas");
    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {
        assertEquals(new Integer(1), opiskelija.getTunnus());
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
}
