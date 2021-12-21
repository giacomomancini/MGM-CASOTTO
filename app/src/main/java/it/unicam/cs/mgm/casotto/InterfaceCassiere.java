package it.unicam.cs.mgm.casotto;

public interface InterfaceCassiere {
    /**
     * "lo scontrino è stato stampato..."
     * "elenco prodotti"
     **/
    void stampa_scontrino(Ordine ordine);

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

}
