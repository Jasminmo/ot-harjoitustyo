package org.otharjoitus.opinnot;

import org.otharjoitus.opinnot.ui.KurssiSuoritusGUI;
import org.otharjoitus.opinnot.ui.KurssiSuoritusUI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //KurssiSuoritusUI ui = new KurssiSuoritusUI(new Scanner(System.in));
        //ui.start();
        KurssiSuoritusGUI.main(args);
    }
}
