package it.unicam.cs.mgm.casotto;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Cliente implements InterfaceCliente {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private int id_carta;
    private int numero_telefono;

    public Cliente(String nome, String cognome, String email, String password, int id_carta, int numero_telefono)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.id_carta = id_carta;
        this.numero_telefono = numero_telefono;

    }


    @Override
    public void prenota_ombrellone() {
        Date data = aggiungi_data();
        double durata = aggiungi_durata();
        int numero_ospiti = aggiungi_numero_ospiti();
        //TODO mostrare la spiaggia con i filtri inseriti dall'utente

    }

    private int aggiungi_numero_ospiti() {
        System.out.println("Inserisci il numero degli ospiti: ");
        Scanner scanner = new Scanner(System.in);
        int ospiti = scanner.nextInt();
        return ospiti;
    }

    private Date aggiungi_data() {
        System.out.println("Inserisci la data di arrivo [gg/mm/aaaa]: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Date d = new Date();
        //converte la stringa della data in un oggetto di classe Date
        try{
            DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            //imposta che i calcoli di conversione della data siano rigorosi
            formatoData.setLenient(false);
            d = formatoData.parse(s);
            return d;
        } catch (ParseException e) {
            System.out.println("Formato data non valido.");
        }
    }

    private double aggiungi_durata() {
        System.out.println("Inserisci la durata della prenotazione:");
        System.out.println("0.5 = mezza giornata");
        System.out.println("1.0 = intera giornata");
        System.out.println("2.5 = due giornate e mezza");
        Scanner scanner = new Scanner(System.in);
        double tempo = scanner.nextDouble();
        return tempo;
    }

    @Override
    public void prenota_zona(String id_zona, Date dataInizio, int durata) {

    }

    @Override
    public void prenota_tavolo(String id_tavolo) {

    }

    @Override
    public void ordina() {

    }

    @Override
    public void iscrizione_attivita(String id_evento) {

    }

    @Override
    public void scrivi_feedback() {

    }

    @Override
    public void inserisci_metodo_pagamento() {

    }

    @Override
    public void richiedi_canzone() {

    }
}
