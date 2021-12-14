package it.unicam.cs.mgm.casotto;

public interface InterfaceProdotto {
    /**
     * metodo per modificare un prodotto (prezzo, descrizione, marca...)
     * @param ID_prodotto
     */
    void modifica_prodotto(Prodotto prodotto);

    /**
     * metodo che aggiunge un nuovo prodotto all'inventario
     * @param ID_prodotto
     * @param descrizione
     * @param quantita
     * @param fornitore
     * @param marca
     * @param prezzo prezzo finale del prodotto
     */
    void aggiungi_prodotto(String ID_prodotto, String descrizione, int quantita, String fornitore, String marca, double prezzo);

    /**
     * metodo che aggiorna l'inventario con nuove quantita di un prodotto
     * @param prodotto
     * @param quantita
     */
    void aggiungi_prodtto (Prodotto prodotto, int quantita);

    void rimuovi_prodotto(Prodotto prodotto);

    void visualizza_prodotti();

}
