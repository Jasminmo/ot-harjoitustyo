package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Kurssi;

import java.io.IOException;
import java.util.List;

public interface KurssiDao {
    /**
     * Lisää Kurssi-olio Dao:n, jos se ei ole jo siellä.
     * @param kurssi
     * @return Kurssi
     * @throws IOException
     */
    Kurssi create(Kurssi kurssi) throws IOException;

    /**
     * Hakee sen kursiin jonka koodi on koodi.
     * @param koodi
     * @return Kurssi
     */
    Kurssi findByKoodi(String koodi);

    /**
     * Hakee kaikki kurssit
     * @return List<Kurssi>
     */
    List<Kurssi> getAll();
}