package it.unicam.cs.mgm.casotto;

public interface InterfaceCassiere {
    void stampa_scontrino(String ID_ordine);

    //modifica la quantità di un prodotto già esistente
    void modifica_conto(String ID_ordine, String ID_prodotto, int nuova_quantità);

    //metodo per aggiungere un nuovo prodotto all'ordine
    void modifica_conto(String ID_ordine);

}
