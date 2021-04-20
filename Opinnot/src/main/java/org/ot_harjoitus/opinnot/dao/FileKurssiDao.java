package org.ot_harjoitus.opinnot.dao;

import org.ot_harjoitus.opinnot.domain.Kurssi;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileKurssiDao implements KurssiDao {
    private List<Kurssi> kurssit;
    private String file;

    public FileKurssiDao(String file) throws Exception {
        kurssit = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                kurssit.add(new Kurssi(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public List<Kurssi> getAll() {
        return kurssit;
    }

    @Override
    public Kurssi create(Kurssi k) throws Exception {
        kurssit.add(k);
        save();
        return k;
    }

    @Override
    public Kurssi findByKoodi(String koodi) {
        return kurssit.stream()
                .filter(k -> k.getKoodi().equals(koodi))
                .findFirst()
                .orElse(null);
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Kurssi kurssi : kurssit) {
                writer.write(kurssi.getKoodi() + ";" + kurssi.getNimi() + ";" + kurssi.getOpintopisteet() + "\n");
            }
        }
    }
}

