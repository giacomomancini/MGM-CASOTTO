package it.unicam.cs.mgm.casotto;

public interface InterfaceProdotto {
    void modifica_prodotto(String ID_prodotto);

    void aggiungi_prodotto(String ID_prodotto, String descrizione, int quantita, String fornitore, String marca, double prezzo);

    void rimuovi_prodotto(String ID_prodotto);

    void visualizza_prodotti();

}
