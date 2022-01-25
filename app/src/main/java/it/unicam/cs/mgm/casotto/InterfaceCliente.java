package it.unicam.cs.mgm.casotto;

import java.util.Date;

public interface InterfaceCliente {
    /**
     * metodo per prenotare un ombrellone
     *
     * timestamp?
     */
    void prenota_ombrellone();

    /**
     * metodo per prenotare una zona dello chalet
     * @param zona id della zona
     * @param durata durata della prenotazione
     */
    void prenota_zona(Zona zona, /*Date dataInizio,*/ double durata);

    void prenota_tavolo(Tavolo tavolo);

    /**
     * metodo per ordinare dall'ombrellone
     */
    void ordina();

    /**
     * metodo per iscriversi ad un'attivita
     */
    void iscrizione_attivita(int id);

    void scrivi_feedback();

    /**
     * metodo per inserire il metodo di pagamento
     */
    void inserisci_metodo_pagamento();

    void richiedi_canzone();

}
