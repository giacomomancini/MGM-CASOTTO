package it.unicam.cs.mgm.casotto;

public interface InterfaceCameriere {

    void modifica_stato_ombrellone(int ID_ombrellone);

    void modifica_stato_tavolo();

    void visualizza_mappa_ristorante();

    void leggi_ordine(String ID_Ordine);

    void modifica_stato_ordine(String ID_ordine);
}
