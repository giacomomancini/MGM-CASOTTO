package it.unicam.cs.mgm.casotto;

import java.util.Date;

public interface InterfaceOmbrellone {

    void modificaPrezzo(double nuovo_prezzo);

    /**
     * calcola il prezzo corrente
     * @param num_lettini numero lettini
     * @param num_sdraio numero sdraio
     * @param num_cabine numero cabine
     * @param num_fila il numero della fila
     * @param mese moltiplicatore associato al mese
     * @return il prezzo corrente
     */
    double calcolaPrezzo(int num_lettini, int num_sdraio, int num_cabine, int num_fila, int mese);

    /**
     * restituisce lo stato dell'ombrellone associato ad una data
     * @param data
     */
    boolean getStato(Date data);

    /**
     * imposta lo stato dell'ombrellone
     * @param ombrellone id dell'ombrellone
     */
    void setStato(Ombrellone ombrellone);

    /**
     * metodo che imposta lo stato di un ombrellone allo scadere di una prenotazione
     */
    void alternaStato();




}
