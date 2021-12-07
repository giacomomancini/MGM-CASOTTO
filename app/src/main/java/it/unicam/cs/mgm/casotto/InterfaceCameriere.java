package it.unicam.cs.mgm.casotto;

public interface InterfaceCameriere {

    /**
     * modifica lo stato dell'ombrellone per un cliente che non lo prenota dall'app
     * @param ID_ombrellone
     */
    void modifica_stato_ombrellone(int ID_ombrellone);

    /**
     * visualizzazione spiaggia per la prenotazione di un cliente che non usa l'app
     */
    void visualizza_stato_spiaggia();

    void modifica_stato_tavolo();

    void visualizza_mappa_ristorante();

    /**
     * stampa l'ordine ricevuto
     * @param ID_Ordine
     */
    void leggi_ordine(String ID_Ordine);

    /**
     * modifica lo stato dell'ordine associato ad un ombrellone (in attesa, in corso)
     * @param ID_ordine
     */
    void modifica_stato_ordine(String ID_ordine);
}
