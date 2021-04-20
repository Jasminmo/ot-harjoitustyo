package org.ot_harjoitus.opinnot;

import org.junit.Before;
import org.junit.Test;
import org.ot_harjoitus.opinnot.domain.Kurssi;

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
        assertEquals(new Integer(5), kurssi.getOpintopisteet());
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
}