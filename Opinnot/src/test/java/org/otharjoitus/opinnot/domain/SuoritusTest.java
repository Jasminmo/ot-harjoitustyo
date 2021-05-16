package org.otharjoitus.opinnot.domain;

import org.junit.Before;
import org.junit.Test;

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
        opiskelija = new Opiskelija("1", "Malli Oppilas");
        date = new Date();
        suoritus = new Suoritus(kurssi, opiskelija, date, 5);
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

        Suoritus toinen = new Suoritus(kurssi, opiskelija, date, 5);
        assertEquals(suoritus, toinen);

        toinen = new Suoritus(kurssi, null, 5);
        assertNotEquals(suoritus, toinen);
    }

    @Test
    public void toStringToimiiOikein() {
        String mjono = "Suoritus{kurssi='Uusi-Kurssi', opiskelija='Malli Oppilas', suoritusHetki='" + date +"'}";
        assertEquals(suoritus.toString(), mjono);
    }
}