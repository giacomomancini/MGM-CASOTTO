package it.unicam.cs.mgm.casotto;

public interface InterfaceOrganizzatoreEventi {
    /**
     *
     * @param username username dell'organizzatore
     */
    void invia_messaggio(String username);

    void crea_evento();

    void modifica_evento();

    void cancella_evento();
}
