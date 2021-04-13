package org.ot_harjoitus.opinnot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final List<Opiskelija> opiskelijat = new ArrayList<>();
    private final List<Kurssi> kurssit = new ArrayList<>();
    private final List<Suoritus> suoritukset = new ArrayList<>();

    public void lisaaOpiskelija(Opiskelija opiskelija) {
        if (!opiskelijat.contains(opiskelija))
            opiskelijat.add(opiskelija);
    }

    public void lisaaKurssi(Kurssi kurssi) {
        if (!kurssit.contains(kurssi))
        kurssit.add(kurssi);
    }

    public void lisaaSuoritus(Suoritus suoritus) {
        if (!suoritukset.contains(suoritus))
        suoritukset.add(suoritus);
    }

    public static void main(String[] args) {
    }
}
