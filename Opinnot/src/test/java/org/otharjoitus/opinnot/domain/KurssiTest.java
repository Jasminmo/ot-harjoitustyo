package org.otharjoitus.opinnot.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KurssiTest {
    Kurssi kurssi;

    @Before
    public void setUp() {
        kurssi = new Kurssi("1", "Uusi-Kurssi", 5);
    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {
        assertEquals("1", kurssi.getKoodi());
        assertEquals("Uusi-Kurssi", kurssi.getNimi());
        assertEquals(Integer.valueOf(5), kurssi.getOpintopisteet());
    }

    @Test(expected=IllegalArgumentException.class)
    public void konstruktoriEiAsettaNegatiivistaOpintopisttä() {
        kurssi = new Kurssi("12345", "Uusi-Kurssi", -5);
    }

    @Test
    public void equalsToimiiOikein() {
        assertEquals(kurssi, kurssi);
        assertNotEquals(kurssi, null);
        assertNotEquals(kurssi, "kurssi");

        Kurssi toinen = new Kurssi("1", "Uusi-Kurssi", 5);
        assertEquals(kurssi, toinen);

        toinen = new Kurssi("10", "Uusi-Kurssi", 5);
        assertNotEquals(kurssi, toinen);
    }

    @Test
    public void toStringToimiiOikein() {
        String mjono = "Kurssi{koodi='1', nimi='Uusi-Kurssi', opintopisteet=5}";
        assertEquals(kurssi.toString(), mjono);
    }
}