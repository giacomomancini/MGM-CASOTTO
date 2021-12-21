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
    private String id_carta;
    private int numero_telefono;

    public Cliente(String nome, String cognome, String email, String password, int numero_telefono)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.id_carta = null;
        this.numero_telefono = numero_telefono;

    }


    @Override
    public void prenota_ombrellone() {
        /*Date data = aggiungi_data();*/
        double durata = aggiungi_durata();
        int numero_ospiti = aggiungi_numero_ospiti();
        //TODO mostrare la spiaggia con i filtri inseriti dall'utente

    }

    @Override
    public void prenota_zona(Zona zona, double durata) {
        double tempo = aggiungi_durata();
        //TODO mostrare le zone non occupate

    }

    @Override
    public void prenota_tavolo(Tavolo tavolo) {

    }

    private int aggiungi_numero_ospiti() {
        System.out.println("Inserisci il numero degli ospiti: ");
        Scanner scanner = new Scanner(System.in);
        int ospiti = scanner.nextInt();
        return ospiti;
    }

    /*private Date aggiungi_data() {
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
    }*/

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
    public void ordina() {
        /**controllo se ha una carta collegata
         * visualizza elenco dei prodotti
         * cliente sceglie i prodotti che vuole acquistare
         * richiede conferma pagamento
         * inserisce qr code ombrello(id_ombrellone)
         * invia ordine al cameriere
         */
    if(this.id_carta == null){
        System.out.println("Per favore inserisci un metodo di pagamento");
        inserisci_metodo_pagamento();
    }
        //TODO visualizza prodotti
        //TODO Scelta dei prodotti
        //TODO Conferma pagamento
        //TODO Inserimento qr code
        //TODO Invia ordine


    }

    @Override
    public void iscrizione_attivita(Evento evento) {
        //TODO visualizzare gli eventi disponibili

    }

    @Override
    public void scrivi_feedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il testo del feedback: ");
        String feedback = scanner.nextLine();
        //TODO aggiungere il feedback alla lista
        scanner.close();
    }

    @Override
    public void inserisci_metodo_pagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il codice della carta: ");
        String carta =scanner.nextLine();
        this.id_carta = carta;
        scanner.close();

    }

    @Override
    public void richiedi_canzone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la canzone: ");
        String canzone = scanner.nextLine();
        //TODO invia la canzone al dj
        scanner.close();
    }
}
