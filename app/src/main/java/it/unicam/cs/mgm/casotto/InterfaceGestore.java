package it.unicam.cs.mgm.casotto;

public interface InterfaceGestore {
    /**
     * metodo che modifica una politica prezzi/promozioni dello chalet
     */
    void modifica_politica();

    /**
     * metodo che aggiunge una zona allo chalet
     */
    void aggiungi_zona();

    /**
     * metodo che rimuove una zona dello chalet
     */
    void rimuovi_zona();

    /**
     * metodo per assumere un dipendente
     *
     */
    void assumi_dipendente();

    void licenzia_dipendente(Dipendente dipendente);

    void leggi_feedback();

    /**
     * metodo che invia un messaggio per notificare promozioni, cambio politiche...agli utenti
     */
    void invia_messaggio();
}
