package org.ot_harjoitus.opinnot;

import org.junit.Before;
import org.junit.Test;
import org.ot_harjoitus.opinnot.domain.Kurssi;
import org.ot_harjoitus.opinnot.domain.Opiskelija;
import org.ot_harjoitus.opinnot.domain.Suoritus;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SuoritusTest {
    Suoritus suoritus;
    Kurssi kurssi;
    Opiskelija opiskelija;
    Date date;

    @Before
    public void setUp() {
        kurssi = new Kurssi("1", "Uusi-Kurssi", 5);
        opiskelija = new Opiskelija("1","Malli Oppilas");
        date = new Date();
        suoritus = new Suoritus(kurssi, opiskelija, date);
    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {
        assertEquals(kurssi, suoritus.getKurssi());
        assertEquals(opiskelija, suoritus.getOpiskelija());
        assertEquals(date, suoritus.getSuoritusHetki());
    }

    @Test
    public void equalsToimiiOikein() {
        assertEquals(suoritus, suoritus);
        assertNotEquals(suoritus, null);
        assertNotEquals(suoritus, "kurssi");

        Suoritus toinen = new Suoritus(kurssi, opiskelija, date);
        assertEquals(suoritus, toinen);

        toinen = new Suoritus(kurssi, null);
        assertNotEquals(suoritus, toinen);
    }
}