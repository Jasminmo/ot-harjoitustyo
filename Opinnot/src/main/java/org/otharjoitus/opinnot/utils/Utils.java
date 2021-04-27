package org.otharjoitus.opinnot.utils;

import org.otharjoitus.opinnot.dao.FileKurssiDao;
import org.otharjoitus.opinnot.dao.FileOpiskelijaDao;
import org.otharjoitus.opinnot.dao.FileSuoritusDao;
import org.otharjoitus.opinnot.domain.KurssiSuoritusService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static KurssiSuoritusService getDefaultService() throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));

        String opiskelijatTiedosto = properties.getProperty("opiskelijatTiedosto");
        String kurssitTiedosto = properties.getProperty("kurssitTiedosto");
        String suorituksetTiedosto = properties.getProperty("suorituksetTiedosto");

        FileKurssiDao kurssiDao = new FileKurssiDao(kurssitTiedosto);
        FileOpiskelijaDao opiskelijaDao = new FileOpiskelijaDao(opiskelijatTiedosto);
        FileSuoritusDao suoritusDao = new FileSuoritusDao(suorituksetTiedosto, kurssiDao, opiskelijaDao);

        return new KurssiSuoritusService(kurssiDao, opiskelijaDao, suoritusDao);
    }
}
