package it.unicam.cs.mgm.casotto;

import java.util.Date;

public interface InterfaceSpiaggia {

    /**
     * imposta lo stato di un ombrellone
     * @param id_ombrellone
     */
    void impostaStatoOmbrellone(Ombrellone ombrellone);

    void aggiungiOmbrellone();

    void eliminaOmbrellone(Ombrellone ombrellone);




}
