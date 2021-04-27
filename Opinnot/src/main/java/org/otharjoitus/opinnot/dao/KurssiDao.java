package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Kurssi;

import java.io.IOException;
import java.util.List;

public interface KurssiDao {
    Kurssi create(Kurssi kurssi) throws IOException;

    Kurssi findByKoodi(String koodi);

    List<Kurssi> getAll();
}