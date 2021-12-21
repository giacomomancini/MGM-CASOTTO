package it.unicam.cs.mgm.casotto;

public interface InterfaceCameriere {

    /**
     * modifica lo stato dell'ombrellone per un cliente che non lo prenota dall'app
     * @param ombrellone
     */
    void modifica_stato_ombrellone(Ombrellone ombrellone);

    /**
     * visualizzazione spiaggia per la prenotazione di un cliente che non usa l'app
     */
    void visualizza_stato_spiaggia();

    void modifica_stato_tavolo();

    void visualizza_mappa_ristorante();

    /**
     * stampa l'ordine ricevuto
     * @param Ordine
     */
    void leggi_ordine(Ordine Ordine);

    /**
     * modifica lo stato dell'ordine associato ad un ombrellone (in attesa, in corso)
     * @param ID_ordine
     */
    void modifica_stato_ordine(String ID_ordine);
}
