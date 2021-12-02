package it.unicam.cs.mgm.casotto;

public interface InterfaceEvento {
    void crea_evento();

    void modifica_evento(String ID_evento);

    void cancella_evento(String ID_evento);
}
