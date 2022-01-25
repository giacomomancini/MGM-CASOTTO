package it.unicam.cs.mgm.casotto;

import it.unicam.cs.mgm.casotto.connettori.ConnettoreCliente;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreUtente;
import it.unicam.cs.mgm.casotto.Privileges;

import java.util.Scanner;

public class Utente implements InterfaceUtente{

    String username;
    String password;
    int privileges;
    ConnettoreCliente Cc = new ConnettoreCliente();
    ConnettoreUtente cu = new ConnettoreUtente();

    public Utente() {}

    public Utente (String username,String password, int privileges) {
        this.username = username;
        this.password = password;
        this.privileges = privileges;
    }

    @Override
    public void registrazione(String username, String password) {
        cu.registrazione(username, password);
        Cliente cliente = new Cliente(username);
        Cc.addCliente(cliente);
    }

    @Override
    public void login(String username, String password) {
        Utente utente = cu.login(username, password);
        switch (utente.getPrivileges()) {
            case 1:
                menu_cliente(username);
                break;
            case 2:
                menu_addettoSpiaggia();
                break;
            case 3:
                menu_cameriere();
                break;
            case 4:
                menu_organizzatoreEventi(username);
                break;
            case 5:
                menu_gestore();
                break;
        }
    }

    private void menu_cameriere() {
    }

    private void menu_organizzatoreEventi(String username) {
        OrganizzatoreEventi oe = new OrganizzatoreEventi();
        int scelta;
        do{
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Invia messaggio ");
            System.out.println("2: Crea evento ");
            System.out.println("3: Modifica evento ");
            System.out.println("4: Cancella evento ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch(scelta) {
                case 1:
                    oe.invia_messaggio(username);
                    break;
                case 2:
                    oe.crea_evento();
                    break;
                case 3:
                    oe.modifica_evento();
                    break;
                case 4:
                    oe.cancella_evento();
                    break;
            }
        }
        while(scelta != 0);
    }

    private void menu_gestore() {
        Gestore gestore = new Gestore();
        int scelta;
        do{
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Modifica prezzo ombrelloni ");
            System.out.println("2: Assumi dipendente ");
            System.out.println("3: Licenzia dipendente ");
            System.out.println("4: Aggiungi ombrellone ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch(scelta) {
                case 1:
                    gestore.modifica_politica();
                    break;
                case 2:
                    gestore.assumi_dipendente();
                    break;
                case 3:
                    gestore.licenzia_dipendente();
                    break;
                case 4:
                    gestore.aggiungi_ombrellone();
                    break;
            }
        }
        while(scelta != 0);
    }


    private void menu_addettoSpiaggia() {
        AddettoSpiaggia as = new AddettoSpiaggia();
        int scelta;
        do{
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Stampa scontrino ");
            System.out.println("2: Modifica prodotto ");
            System.out.println("3: Aggiungi prodotto ");
            System.out.println("4: Rimuovi prodotto ");
            System.out.println("5: Modifica stato ombrellone ");
            System.out.println("6: Leggi ordine ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch(scelta) {
                case 1:
                    as.stampa_scontrino();
                    break;
                case 2:
                    as.modifica_prodotto();
                    break;
                case 3:
                    as.aggiungi_prodotto();
                    break;
                case 4:
                    as.rimuovi_prodotto();
                    break;
                case 5:
                    as.modifica_stato_ombrellone();
                    break;
                case 6:
                    as.leggi_ordine();
                    break;
            }
        }
        while(scelta != 0);
    }

    private void menu_cliente(String username) {
        Cliente cliente = Cc.getCliente(username);
        int scelta;
        do{
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("1: Prenota ombrellone ");
            System.out.println("2: Ordinazione bar ");
            System.out.println("3: Iscrizione attività ");
            System.out.println("4: Inserisci metodo pagamento ");
            System.out.println("0: Esci ");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch(scelta) {
                case 1:
                    cliente.prenota_ombrellone();
                    break;
                case 2:
                    cliente.ordina();
                    break;
                case 3:
                    cliente.iscrizione_attivita();
                    break;
                case 4:
                    cliente.inserisci_metodo_pagamento();
                    break;
            }
        }
        while(scelta != 0);
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrivileges() {
        return privileges;
    }

    public void setPrivileges(int privileges) {
        this.privileges = privileges;
    }

    public ConnettoreUtente getCu() {
        return cu;
    }

    public void setCu(ConnettoreUtente cu) {
        this.cu = cu;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
