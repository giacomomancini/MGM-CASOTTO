package it.unicam.cs.mgm.casotto;

import it.unicam.cs.mgm.casotto.connettori.ConnettoreCliente;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreOmbrellone;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreOrdine;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreProdotto;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddettoSpiaggia implements InterfaceAddettoSpiaggia{
    ConnettoreProdotto cp = new ConnettoreProdotto();
    ConnettoreOmbrellone co = new ConnettoreOmbrellone();
    ConnettoreOrdine cOrd = new ConnettoreOrdine();
    ConnettoreCliente cc = new ConnettoreCliente();

    @Override
    public void stampa_scontrino() {
        System.out.println("digita l'email del cliente");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        List<Ordine> ordini = cOrd.getScontrino(email);
        for(Ordine ordine : ordini)
            System.out.println(ordine.toString());
    }

    public void modifica_prodotto(){
        System.out.println("digita l'ID del prodotto che vuoi modificare:");
        visualizza_prodotti();
        Scanner scanner = new Scanner(System.in);
        String scelta = scanner.nextLine();
        modifica_prodotto(cp.getProduct(scelta));
    }

    @Override
    public void modifica_conto(Ordine ordine, Prodotto prodotto, int nuova_quantita) {

    }

    @Override
    public void modifica_conto(Ordine ordine, Prodotto prodotto) {

    }

    @Override
    public void aggiungi_prodotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digita l'id:");
        String id = scanner.nextLine();
        System.out.println("Digita il nome:");
        String nome = scanner.nextLine();
        System.out.println("Digita la descrizione:");
        String descrizione = scanner.nextLine();
        System.out.println("Digita la quantità:");
        int quantita = scanner.nextInt();
        System.out.println("Digita il fornitore:");
        String fornitore = scanner.nextLine();
        System.out.println("Digita la marca:");
        String marca = scanner.nextLine();
        System.out.println("Digita il prezzo:");
        double prezzo = scanner.nextDouble();
        aggiungi_prodotto(id, nome, descrizione, quantita, fornitore, marca, prezzo);
    }

    @Override
    public void rimuovi_prodotto() {
        //TODO gestire eccezioni
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digita l'id del prodotto da rimuovere");
        visualizza_prodotti();
        String scelta = scanner.nextLine();
        rimuovi_prodotto(scelta);

    }


    public void visualizza_prodotti() {
        List<Prodotto> prodotti = cp.getAllProducts();
        for(Prodotto prodotto : prodotti){
            System.out.println(prodotto.toString());
        }
    }

    @Override
    public void modifica_stato_ombrellone(){
        List<Ombrellone> ombrelloni = co.getOmbrelloniOccupati();
        for (Ombrellone ombrellone : ombrelloni) {
            System.out.println(ombrellone.toString());
        }
        System.out.println("Digita l'id dell'ombrellone che vuoi liberare");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        co.liberaOmbrellone(id);
        cc.rimuoviPrenotazione(id);
    }

    @Override
    public void leggi_ordine() {
        List<Ordine> ordini = cOrd.getOrdini();
        for ( Ordine ordine : ordini)
            System.out.println(ordine.toString());

    }

    private void modifica_prodotto(Prodotto prodotto) {
        /**
         * scegli attributo da modificare
         * insersci nuovo valore
         */
        System.out.println("Inserisci il campo da modificare: ");
        System.out.println("1: Prezzo ");
        System.out.println("2: Quantità ");
        System.out.println("3: Marca ");
        System.out.println("4: Descrizione ");
        System.out.println("5: Fornitore ");
        System.out.println("0: Esci ");
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        switch(scelta) {
            case 1:
                System.out.println("inserisci il nuovo prezzo");
                double prezzo = scanner.nextDouble();
                prodotto.setPrezzo(prezzo);
                break;
            case 2:
                System.out.println("inserisci la nuova quantità");
                int quantita = scanner.nextInt();
                prodotto.setQuantita(quantita);
                break;
            case 3:
                System.out.println("inserisci la nuova marca");
                String marca = scanner.nextLine();
                prodotto.setMarca(marca);
                break;
            case 4:
                System.out.println("inserisci la nuova descrizione");
                String descrizione = scanner.nextLine();
                prodotto.setDescrizione(descrizione);
                break;
            case 5:
                System.out.println("inserisci il nuovo fornitore");
                String fornitore = scanner.nextLine();
                prodotto.setFornitore(fornitore);
                break;
        }
        cp.updateProdotto(prodotto);
        System.out.println("vuoi fare altre modifiche? 1=Si/2=No");
        scelta = scanner.nextInt();
        if (scelta == 1)
            modifica_prodotto(prodotto);

    }

    public void rimuovi_prodotto(String id) {
        cp.deleteProdotto(id);
    }

    public void aggiungi_prodotto(String ID_prodotto,String nome, String descrizione, int quantita, String fornitore, String marca, double prezzo) {
        Prodotto nuovo_prodotto= new Prodotto(ID_prodotto, nome, descrizione, quantita, fornitore, marca, prezzo);
        cp.addProdotto(nuovo_prodotto);

    }
}
