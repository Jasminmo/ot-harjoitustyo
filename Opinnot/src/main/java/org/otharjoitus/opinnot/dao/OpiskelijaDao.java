package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Opiskelija;

import java.io.IOException;
import java.util.List;

public interface OpiskelijaDao  {
    /**
     * Lisää Opiskelija-olio Dao:n, jos se ei ole jo siellä.
     * @param opiskelija
     * @return opiskelija
     * @throws IOException
     */
    Opiskelija create(Opiskelija opiskelija) throws IOException;

    /**
     * Hakee sen opiskelijan jonka tunnus on opiskelijaTunnus
     * @param opiskelijaTunnus
     * @return
     */
    Opiskelija findByTunnus(String opiskelijaTunnus);

    /**
     * Hakee sen opiskelijan jonka sahkoposti on sahkoposti
     * @param sahkoposti
     * @return
     */
    Opiskelija findBySahkoposti(String sahkoposti);

    /**
     * Hakee kaikki opiskelijat Dao:sta.
     * @return List<Opiskelija>
     */
    List<Opiskelija> getAll();
}