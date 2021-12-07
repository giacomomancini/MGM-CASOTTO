package it.unicam.cs.mgm.casotto;

public interface InterfaceCassiere {
    /**
     * "lo scontrino è stato stampato..."
     * "elenco prodotti"
     **/
    void stampa_scontrino(String ID_ordine);

    /**
     * modifica la quantita di un prodotto gia esistente in un conto
     */
    void modifica_conto(String ID_ordine, String ID_prodotto, int nuova_quantita);

    /**
     * metodo per aggiungere un nuovo prodotto all'ordine
     * @param ID_ordine id dell'ordine da cambiare
     * @param ID_prodotto id nuovo prodotto da inserire
     */
    void modifica_conto(String ID_ordine, String ID_prodotto);

}
