package org.ot_harjoitus.opinnot.dao;

import org.ot_harjoitus.opinnot.domain.Opiskelija;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOpiskelijaDoa implements OpiskelijaDao {

    private List<Opiskelija> opiskelijat;
    private String filename;

    public FileOpiskelijaDoa(String file) throws Exception {
        opiskelijat = new ArrayList<>();
        filename = file;

        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                opiskelijat.add(new Opiskelija(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(filename));
            writer.close();
        }
    }

    @Override
    public List<Opiskelija> getAll() {
        return opiskelijat;
    }

    @Override
    public Opiskelija create(Opiskelija o) throws Exception {
        opiskelijat.add(o);
        save();
        return o;
    }

    @Override
    public Opiskelija findByTunnus(String t) {
        return opiskelijat.stream()
                .filter(o -> o.getTunnus().equals(t))
                .findFirst()
                .orElse(null);
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            for (Opiskelija o : opiskelijat) {
                writer.write(o.getTunnus() + ";" + o.getNimi() + ";" + o.getSahkoposti()  + ";" + o.getSalasana() + "\n");
            }
        }
    }
}
