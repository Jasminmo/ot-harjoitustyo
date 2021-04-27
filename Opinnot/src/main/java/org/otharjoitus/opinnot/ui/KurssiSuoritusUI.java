package org.otharjoitus.opinnot.ui;

import org.otharjoitus.opinnot.domain.Kurssi;
import org.otharjoitus.opinnot.domain.KurssiSuoritusService;
import org.otharjoitus.opinnot.domain.Opiskelija;
import org.otharjoitus.opinnot.domain.Suoritus;
import org.otharjoitus.opinnot.utils.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class KurssiSuoritusUI {
    private Scanner scanner;
    private Map<String, String> commands;
    private KurssiSuoritusService service;

    public KurssiSuoritusUI(Scanner s) throws IOException {
        scanner = s;
        service = Utils.getDefaultService();

        commands = new TreeMap<>();
        commands.put("x", "x lopeta");
        commands.put("1", "1 hae kurssit");
        commands.put("2", "2 hae opiskelijat");
        commands.put("3", "3 hae suoritukset");
        commands.put("4", "4 lisää kurssi");
        commands.put("5", "5 lisää opiskelija");
        commands.put("6", "6 lisää suoritus");
    }

    public void start() {
        printHelp();


        while (true) {
            System.out.println();
            System.out.print("komento: ");
            String command = scanner.nextLine();
            if (!commands.keySet().contains(command)) {
                System.out.println("virheellinen komento.");
                printHelp();
            }

            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                tulostaKurssit();
            } else if (command.equals("2")) {
                tulostaOpiskelijat();
            } else if (command.equals("3")) {
                tulostaSuoritukset();
            } else if (command.equals("4")) {
                lisaaKurssi();
            } else if (command.equals("5")) {
                lisaaOpiskelija();
            } else if (command.equals("6")) {
                lisaaSuoritus();
            }

        }
    }

    private void tulostaKurssit() {
        service.getKurssit().stream().forEachOrdered(System.out::println);
    }

    private void tulostaOpiskelijat() {
        service.getOpiskelijat().stream().forEachOrdered(System.out::println);
    }

    private void tulostaSuoritukset() {
        service.getSuoritukset().stream().forEachOrdered(System.out::println);
    }

    private void lisaaKurssi() {
        System.out.print("koodi: ");
        String koodi = scanner.nextLine();
        System.out.print("nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("op: ");
        String op = scanner.nextLine();
        Kurssi kurssi = new Kurssi(koodi, nimi, Integer.parseInt(op));
        try {
            service.lisaaKurssi(kurssi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lisaaOpiskelija() {
        System.out.print("opiskelija tunnus: ");
        String koodi = scanner.nextLine();
        System.out.print("nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("sähköposti: ");
        String sposti = scanner.nextLine();
        System.out.print("salasana: ");
        String salasana = scanner.nextLine();
        Opiskelija opiskelija = new Opiskelija(koodi, nimi, sposti, salasana);
        try {
            service.lisaaOpiskelija(opiskelija);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lisaaSuoritus() {
        System.out.print("kurssikoodi: ");
        String koodi = scanner.nextLine();
        System.out.print("opiskelija tunnus: ");
        String tunnus = scanner.nextLine();
        Kurssi kurssi = service.getKurssi(koodi);
        Opiskelija opiskelija = service.getOpiskelija(tunnus);
        Suoritus suoritus = new Suoritus(kurssi, opiskelija);
        try {
            service.lisaaSuoritus(suoritus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printHelp() {
        System.out.println("Opintorekisteri palvelu.");

        System.out.println("Käytössä olevat komennot:");
        for (int i = 1; i < commands.size(); i++) {
            System.out.println(commands.get(Integer.toString(i)));
        }
        System.out.println("x lopeta");
    }
}
