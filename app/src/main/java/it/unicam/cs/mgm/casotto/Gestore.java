package it.unicam.cs.mgm.casotto;

import it.unicam.cs.mgm.casotto.connettori.ConnettoreOmbrellone;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreUtente;

import java.util.List;
import java.util.Scanner;

public class Gestore implements InterfaceGestore {
    ConnettoreUtente cu = new ConnettoreUtente();
    ConnettoreOmbrellone co = new ConnettoreOmbrellone();

    @Override
    public void modifica_politica() {
        System.out.println("Inserisci moltiplicatore prezzo");
        Scanner scanner = new Scanner(System.in);
        double moltiplicatore = scanner.nextDouble();
        List<Ombrellone> ombrelloni = co.getAllOmbrelloni();
        for (Ombrellone ombrellone : ombrelloni) {
            double totale = ombrellone.getPrezzo() * moltiplicatore;
            co.modificaPrezzo(totale, ombrellone.getId());
        }
    }

    @Override
    public void assumi_dipendente() {
        List<Utente> utenti = cu.getClienti();
        for(Utente utente : utenti)
            System.out.println(utente.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digita l'email di chi vuoi assumere");
        String email = scanner.nextLine();
        System.out.println("Digita il ruolo che vuoi dargli");
        System.out.println("2-Addetto spiaggia");
        System.out.println("3-Cameriere");
        System.out.println("4-Organizzatore eventi");
        System.out.println("5-Gestore");
        int ruolo = scanner.nextInt();
        cu.aggiornaRuolo(email, ruolo);
    }

    @Override
    public void licenzia_dipendente() {
        List<Utente> utenti = cu.getDipendenti();
        for(Utente utente : utenti)
            System.out.println(utente.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digita l'email di chi vuoi licenziare");
        String email = scanner.nextLine();
        cu.LicenziaDipendente(email);
    }

    @Override
    public void aggiungi_ombrellone() {
        //TODO qrcode primary key
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Inserisci id ombrellone: ");
        String id = scanner.nextLine();
        System.out.println("Inserisci numero fila: ");
        int num_fila = scanner.nextInt();
        System.out.println("Inserisci prezzo: ");
        double prezzo = scanner.nextDouble();
        System.out.println("Inserisci QRCode: ");
        String QRCode = scanner2.nextLine();
        System.out.println("Inserisci numero lettini: ");
        int num_lettini = scanner.nextInt();
        System.out.println("Inserisci numero sdraie: ");
        int num_sdraie = scanner.nextInt();
        System.out.println("Inserisci numero cabine: ");
        int num_cabine = scanner.nextInt();
        System.out.println("Inserisci numero massimo ospiti: ");
        int num_ospiti = scanner.nextInt();
        Ombrellone ombrellone = new Ombrellone(id, num_fila, prezzo, QRCode, num_lettini, num_sdraie, num_cabine, num_ospiti);
        co.AddOmbrellone(ombrellone);
    }









    @Override
    public void leggi_feedback() {

    }
    @Override
    public void invia_messaggio() {

    }

    @Override
    public void rimuovi_zona() {

    }

    @Override
    public void aggiungi_zona() {

    }

}
