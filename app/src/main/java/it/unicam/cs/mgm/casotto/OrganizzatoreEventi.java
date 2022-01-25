package it.unicam.cs.mgm.casotto;

import it.unicam.cs.mgm.casotto.connettori.ConnettoreCliente;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreEvento;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreMessaggi;
import it.unicam.cs.mgm.casotto.connettori.ConnettoreProdotto;

import java.util.List;
import java.util.Scanner;

public class OrganizzatoreEventi implements InterfaceOrganizzatoreEventi {
    ConnettoreEvento ce = new ConnettoreEvento();
    ConnettoreMessaggi cm = new ConnettoreMessaggi();

    @Override
    public void invia_messaggio(String username) {
        ConnettoreCliente cc = new ConnettoreCliente();
        System.out.println("Digita il messaggio");
        Scanner scanner = new Scanner(System.in);
        String messaggio = scanner.nextLine();
        List<Cliente> clienti = cc.getClienteConOmbrellone();
        for(Cliente cliente : clienti) {
            Messaggio mess = new Messaggio(0,username, cliente.getEmail(), messaggio);
            cm.addMessaggio(mess);

        }
    }

    @Override
    public void crea_evento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digita nome evento");
        String nome = scanner.nextLine();
        System.out.println("digita descrizione evento");
        String descrizione = scanner.nextLine();
        System.out.println("digita data evento");
        String data = scanner.nextLine();
        System.out.println("digita il numero minimo di partecipanti evento");
        int min = scanner.nextInt();
        System.out.println("digita il numero massimo di evento");
        int max = scanner.nextInt();
        System.out.println("digita il numero di iscritti");
        int iscritti = scanner.nextInt();
        crea_evento( nome, descrizione, data, min, max, iscritti);
    }

    private void crea_evento( String nome, String descrizione, String data, int min, int max, int iscritti) {
        Evento evento = new Evento(nome, descrizione, data, min, max, iscritti);
        ce.addEvento(evento);
    }
    @Override
    public void modifica_evento(){
        System.out.println("digita l'ID dell'evento che vuoi modificare:");
        visualizza_eventi();
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        modifica_evento(ce.getEvento(scelta));
    }

    private void visualizza_eventi() {
        List<Evento> eventi = ce.getAllEventi();
        for(Evento evento : eventi){
            System.out.println(evento.toString());
        }
    }

    public void modifica_evento(Evento evento) {
        System.out.println("Inserisci il campo da modificare: ");
        System.out.println("1: Nome ");
        System.out.println("2: Descrizione ");
        System.out.println("3: Data");
        System.out.println("4: Numero minimo partecipanti");
        System.out.println("5: Numero massimo partecipanti ");
        System.out.println("0: Esci ");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int scelta = scanner.nextInt();
        switch(scelta) {
            case 1:
                System.out.println("inserisci il nuovo nome");
                String nome= scanner2.nextLine();
                evento.setNome(nome);
                break;
            case 2:
                System.out.println("inserisci la nuova descrizione");
                String descrizione = scanner2.nextLine();
                evento.setDescrizione(descrizione);
                break;
            case 3:
                System.out.println("inserisci la nuova data");
                String data = scanner2.nextLine();
                evento.setData(data);
                break;
            case 4:
                System.out.println("inserisci il nuovo numero minimo di partecipanti");
                int min = scanner2.nextInt();
                evento.setNumero_min_partecipanti(min);
                break;
            case 5:
                System.out.println("inserisci il nuovo numero massimo di partecipanti");
                int max = scanner2.nextInt();
                evento.setNumero_max_partecipanti(max);
                break;
        }
        ce.updateEvento(evento);
    }

    @Override
    public void cancella_evento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digita l'id dell'evento da rimuovere");
        visualizza_eventi();
        int id = scanner.nextInt();
        rimuovi_evento(id);
    }

    private void rimuovi_evento(int id) {
        ce.deleteEvento(id);
    }
}
