package org.ot_harjoitus.opinnot.dao;

import org.ot_harjoitus.opinnot.domain.Kurssi;
import org.ot_harjoitus.opinnot.domain.Opiskelija;
import org.ot_harjoitus.opinnot.domain.Suoritus;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSuoritusDao implements SuoritusDao {
    public final List<Suoritus> suoritukset;
    private final String filename;
    private final SimpleDateFormat dateFormatter;

    public FileSuoritusDao(String file, KurssiDao kurssit, OpiskelijaDao opiskelijat) throws Exception {
        suoritukset = new ArrayList<>();
        filename = file;
        dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                Kurssi kurssi = kurssit
                        .getAll().stream()
                        .filter(k->k.getKoodi().equals(parts[0])).findFirst().orElse(null);
                Opiskelija opiskelija = opiskelijat
                        .getAll().stream()
                        .filter(o->o.getTunnus().equals(parts[1])).findFirst().orElse(null);
                Suoritus s = new Suoritus(kurssi, opiskelija, dateFormatter.parse(parts[2]));
                suoritukset.add(s);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(filename));
            writer.close();
        }
    }

    private void save() throws Exception{
        try (FileWriter writer = new FileWriter(new File(filename))) {
            for (Suoritus s : suoritukset) {
                writer.write(s.getKurssi().getKoodi() + ";" + s.getOpiskelija().getTunnus() + ";" + dateFormatter.format(s.getSuoritusHetki()) + "\n");
            }
        }
    }

    @Override
    public List<Suoritus> getAll() {
        return suoritukset;
    }

    @Override
    public Suoritus create(Suoritus s) throws Exception {
        suoritukset.add(s);
        save();
        return s;
    }

}
