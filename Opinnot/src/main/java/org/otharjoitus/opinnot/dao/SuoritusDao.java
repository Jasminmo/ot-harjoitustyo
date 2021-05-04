package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Suoritus;

import java.io.IOException;
import java.util.List;

public interface SuoritusDao {
    /**
     * Lisää Suoritus-olio Dao:n, jos se ei ole jo siellä.
     * @param s
     * @return s
     * @throws IOException
     */
    Suoritus create(Suoritus s) throws IOException;

    /**
     * Hakee kaikki Suoritus oliot Dao:sta.
     * @return List<Suoritus>
     */
    List<Suoritus> getAll();

    /**
     * Hakee opiskelijan Suoritukset Dao:sta.
     * @param tunnus
     * @return List<Suoritus>
     */
    List<Suoritus> getOpiskelijanSuoritukset(String tunnus);
}