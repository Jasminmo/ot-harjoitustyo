package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Suoritus;

import java.io.IOException;
import java.util.List;

public interface SuoritusDao {
    Suoritus create(Suoritus s) throws IOException;

    List<Suoritus> getAll();
}