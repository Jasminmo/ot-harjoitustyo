package org.ot_harjoitus.opinnot.dao;

import org.ot_harjoitus.opinnot.domain.Kurssi;
import java.util.List;

public interface KurssiDao {
    Kurssi create(Kurssi kurssi) throws Exception;

    Kurssi findByKoodi(String koodi);

    List<Kurssi> getAll();
}