package it.unicam.cs.mgm.casotto;

import it.unicam.cs.mgm.casotto.connettori.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Cliente implements InterfaceCliente {
    private ConnettoreOmbrellone co = new ConnettoreOmbrellone();
    private ConnettoreProdotto cp = new ConnettoreProdotto();
    private ConnettoreOrdine cOrd = new ConnettoreOrdine();
    private ConnettoreCliente Cc = new ConnettoreCliente();
    private ConnettoreMessaggi cm = new ConnettoreMessaggi();
    private ConnettoreEvento ce = new ConnettoreEvento();

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String id_carta;
    private String numero_telefono;
    private String id_ombrellone_occupato = null;

    public Cliente(String email, String nome, String cognome, String id_carta, String numero_telefono) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.id_carta = id_carta;
        this.numero_telefono = numero_telefono;
    }

    public Cliente(String username) {
        this.email = username;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente() {

    }
    public void leggi_messaggi(){
        List<Messaggio> messaggi = cm.leggiMessaggi(this.getEmail());
        for(Messaggio messaggio : messaggi)
            messaggio.toString();
    }

    @Override
    public void prenota_ombrellone() {
        double durata = aggiungi_durata();
        int numero_ospiti = aggiungi_numero_ospiti();
        List<Ombrellone> ombrelloni = co.getAvailableOmbrelloni(numero_ospiti);
        for (Ombrellone ombrellone : ombrelloni) {
            System.out.println(ombrellone.toString());
        }
        System.out.println("Digita l'id dell'ombrellone che vuoi prenotare");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        co.setOmbrelloneOccupato(id);
        double prezzo = co.getPrezzo(id);
        boolean ris = Cc.AssegnaOmbrellone(this.email, id);
        double totale = prezzo*durata;
        if(ris == true){
            System.out.println("Prenotazione effettuata con successo - dirigiti alla cassa per pagare");
            System.out.println("Totale : "+ totale);
        }

        else
            System.out.println("Prenotazione non effettuata, riprova");
    }

    @Override
    public void prenota_zona(Zona zona, double durata) {


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
    if(this.id_carta == null){
        System.out.println("Per favore inserisci un metodo di pagamento");
        inserisci_metodo_pagamento();
    }
        List<Prodotto> prodotti = cp.getAllProducts();
        for(Prodotto prodotto : prodotti){
            System.out.println(prodotto.toString());
        }
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String scelta;
        double totale;
        int continuaAcquisti;
        do {
            System.out.println("Digita l'id del prodotto che vuoi acquistare");
            scelta = scanner.nextLine();
            System.out.println("Digita la quantità che vuoi acquistare");
            int quantita = scanner2.nextInt();
            cOrd.addOrdine(new Ordine(0, scelta, this.email, quantita));
            totale=+ cp.getPrezzoOrdine(scelta, quantita);
            System.out.println("vuoi comprare ancora? 1-si 0-no");
            continuaAcquisti = scanner2.nextInt();
        }while(continuaAcquisti !=0);
        System.out.println("Totale:" + totale);
        System.out.println("Confermi il pagamento? Si/No");
        scelta = scanner.nextLine();
        if(scelta.equals("Si")) {
            System.out.println("Inserisci QRCode:");
            scelta = scanner.nextLine();
        }


    }
    public void iscrizione_attivita() {
        Scanner scanner = new Scanner(System.in);
        List<Evento> eventi = ce.getEventiDisponibili();
        for(Evento evento : eventi)
            System.out.println(evento.toString());
        System.out.println("Inserisci l'id dell'evento a cui vuoi iscriverti: ");
        int scelta = scanner.nextInt();
        iscrizione_attivita(scelta);
    }

    @Override
    public void iscrizione_attivita(int id) {
        int iscritti = ce.getNumeroIscritti(id) + 1;
        ce.AggiornaIscritti(iscritti, id);


    }

    @Override
    public void scrivi_feedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il testo del feedback: ");
        String feedback = scanner.nextLine();
        scanner.close();
    }

    @Override
    public void inserisci_metodo_pagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il codice della carta: ");
        String carta = scanner.nextLine();
        this.id_carta = carta;
        Cc.addCarta(carta, this.getEmail());

    }

    @Override
    public void richiedi_canzone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la canzone: ");
        String canzone = scanner.nextLine();
        //TODO invia la canzone al dj
        scanner.close();
    }

    public ConnettoreOmbrellone getCo() {
        return co;
    }

    public void setCo(ConnettoreOmbrellone co) {
        this.co = co;
    }

    public ConnettoreProdotto getCp() {
        return cp;
    }

    public void setCp(ConnettoreProdotto cp) {
        this.cp = cp;
    }

    public ConnettoreOrdine getcOrd() {
        return cOrd;
    }

    public void setcOrd(ConnettoreOrdine cOrd) {
        this.cOrd = cOrd;
    }

    public ConnettoreCliente getCc() {
        return Cc;
    }

    public void setCc(ConnettoreCliente cc) {
        Cc = cc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_carta() {
        return id_carta;
    }

    public void setId_carta(String id_carta) {
        this.id_carta = id_carta;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
}
