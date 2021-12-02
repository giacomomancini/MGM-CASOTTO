package it.unicam.cs.mgm.casotto;

public interface InterfaceGestore {
    void modifica_politiche();

    void gestione_struttura();

    void assumi_dipendente(String Nome, String Cognome, String email);

    void licenzia_dipendente(Dipendente dipendente);

    void leggi_feedback();
}
