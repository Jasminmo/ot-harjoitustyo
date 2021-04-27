package org.otharjoitus.opinnot.domain;

import org.otharjoitus.opinnot.dao.KurssiDao;

import java.util.ArrayList;
import java.util.List;

public class FakeKurssiDao implements KurssiDao {

    List<Kurssi> kurssit = new ArrayList<>();

    public FakeKurssiDao() {
        kurssit.add(new Kurssi("1", "Uusi-Kurssi", 5));
    }

    @Override
    public Kurssi findByKoodi(String koodi) {
        return kurssit.stream().filter(u->u.getKoodi().equals(koodi)).findFirst().orElse(null);
    }

    @Override
    public Kurssi create(Kurssi k) {
        kurssit.add(k);
        return k;
    }

    @Override
    public List<Kurssi> getAll() {
        return kurssit;
    }
}
