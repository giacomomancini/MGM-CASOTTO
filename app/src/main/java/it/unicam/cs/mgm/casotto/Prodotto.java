package it.unicam.cs.mgm.casotto;

import java.util.Scanner;

public class Prodotto implements InterfaceProdotto{
    private String id_prodotto;
    private String nome;
    private double prezzo;
    private int quantita;
    private String marca;
    private String descrizione;
    private String fornitore;

    public Prodotto(String id_prodotto, String nome, String descrizione, int quantita, String fornitore, String marca, double prezzo) {
        this.id_prodotto = id_prodotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.fornitore = fornitore;
        this.marca = marca;
        this.prezzo = prezzo;
    }


    @Override
    public void modifica_prodotto(Prodotto prodotto) {
        /**
         * scegli attributo da modificare
         * insersci nuovo valore
         */
        //TODO modificare anche database
        System.out.println("Inserisci il campo da modificare: ");
        System.out.println("1: Prezzo ");
        System.out.println("2: Quantità ");
        System.out.println("3: Marca ");
        System.out.println("4: Descrizione ");
        System.out.println("5: Fornitore ");
        System.out.println("0: Esci ");
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        switch(scelta){
            case 1:
                System.out.println("inserisci il nuovo prezzo");
                double prezzo = scanner.nextDouble();
                prodotto.setPrezzo = prezzo;
                break;
            case 2:
                System.out.println("inserisci la nuova quantità");
                int quantita = scanner.nextInt();
                prodotto.setQuantita = quantita;
                break;
            case 3:
                System.out.println("inserisci la nuova marca");
                String marca = scanner.nextLine();
                prodotto.setMarca = marca;
                break;
            case 4:
                System.out.println("inserisci la nuova descrizione");
                String descrizione = scanner.nextLine();
                prodotto.setDescrizione = descrizione;
                break;
            case 5:
                System.out.println("inserisci il nuovo fornitore");
                String fornitore = scanner.nextLine();
                prodotto.setFornitore = fornitore;
                break;
            System.out.println("vuoi fare altre modifiche? 1=Si/2=No");
            scelta = scanner.nextInt();
            if (scelta == 1)
                modifica_prodotto(prodotto);
        }
    }

    @Override
    public void aggiungi_prodotto(String ID_prodotto,String nome, String descrizione, int quantita, String fornitore, String marca, double prezzo) {
        Prodotto nuovo_prodotto= new Prodotto(ID_prodotto, nome, descrizione, quantita, fornitore, marca, prezzo);
        //TODO aggiungi al database

    }


    @Override
    public void rimuovi_prodotto(Prodotto prodotto) {
    //TODO rimuovi dal database
    }

    @Override
    public void visualizza_prodotti() {
    //TODO visualizza oggetti nel database
    }
}
