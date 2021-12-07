package it.unicam.cs.mgm.casotto;

import java.util.Date;

public interface InterfaceCliente {
    /**
     * metodo per prenotare un ombrellone
     * @param num_ospiti numero degli ospiti
     * @param dataInizio data inizio prenotazione
     * @param durata durata della prenotazione
     * @param id_ombrellone id dell'ombrellone
     *
     * timestamp?
     */
    void prenota_ombrellone(int num_ospiti, Date dataInizio, int durata, int id_ombrellone);

    /**
     * metodo per prenotare una zona dello chalet
     * @param id_zona id della zona
     * @param dataInizio data di inizio prenotazione
     * @param durata durata della prenotazione
     */
    void prenota_zona(String id_zona, Date dataInizio, int durata);

    void prenota_tavolo(String id_tavolo);

    /**
     * metodo per ordinare dall'ombrellone
     */
    void ordina();

    /**
     * metodo per iscriversi ad un'attivita
     * @param id_evento
     */
    void iscrizione_attivita(String id_evento);

    void scrivi_feedback();

    /**
     * metodo per inserire il metodo di pagamento
     */
    void inserisci_metodo_pagamento();

    void richiedi_canzone();

}
