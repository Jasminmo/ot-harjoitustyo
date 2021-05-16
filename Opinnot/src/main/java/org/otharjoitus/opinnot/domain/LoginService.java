package org.otharjoitus.opinnot.domain;

import org.otharjoitus.opinnot.dao.FileOpiskelijaDao;

public class LoginService {
    private FileOpiskelijaDao dao;

    public LoginService(FileOpiskelijaDao opiskelijaDao) {
        dao = opiskelijaDao;
    }

    public Opiskelija studentLogin(String email, String password) {
        Opiskelija opiskelija = dao.findBySahkoposti(email);
        if (opiskelija == null || !opiskelija.getSalasana().equals(password)) {
            return null;
        }
        return opiskelija;
    }

    public boolean adminLogin(String password) {
        return password.equals("salasana");
    }
}
