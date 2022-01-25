package it.unicam.cs.mgm.casotto;

import java.sql.SQLException;

public interface InterfaceAddettoSpiaggia {
    /**
     * "lo scontrino è stato stampato..."
     * "elenco prodotti"
     **/
    void stampa_scontrino();

    /**
     * metodo per modificare uno o più dati di un prodotto
     */

    void modifica_prodotto();

    /**
     * modifica la quantita di un prodotto gia esistente in un conto
     */
    void modifica_conto(Ordine ordine, Prodotto prodotto, int nuova_quantita);

    /**
     * metodo per aggiungere un nuovo prodotto all'ordine
     * @param ordine ordine da cambiare
     * @param prodotto nuovo prodotto da inserire
     */
    void modifica_conto(Ordine ordine, Prodotto prodotto);

    void aggiungi_prodotto();

    void rimuovi_prodotto();

    void visualizza_prodotti();

    void modifica_stato_ombrellone() throws SQLException;

    void leggi_ordine();
}
