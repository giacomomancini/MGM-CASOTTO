package it.unicam.cs.mgm.casotto;

import java.util.Date;

public class Ombrellone implements InterfaceOmbrellone {

    private int num_fila;
    private double prezzo;
    private int id;
    private int num_ospiti;
    private boolean isFree = true; //TODO serve?


    public Ombrellone(int num_fila, double prezzo, int id, int num_ospiti) {
        this.num_fila = num_fila;
        this.prezzo = prezzo;
        this.id = id;
        this.num_ospiti = num_ospiti;
    }


    @Override
    public void modificaPrezzo(double nuovo_prezzo) {

    }

    @Override
    public double calcolaPrezzo(int num_lettini, int num_sdraio, int num_cabine, int num_fila, int mese) {
        return 0;
    }

    @Override
    public boolean getStato(Date data) {
        return false;
    }

    @Override
    public void setStato(int id_ombrellone) {

    }

    @Override
    public void alternaStato() {

    }
}
