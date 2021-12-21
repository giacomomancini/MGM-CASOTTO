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
        this.prezzo = nuovo_prezzo;
        //TODO modifica sul database

    }

    @Override
    public double calcolaPrezzo(int num_lettini, int num_sdraio, int num_cabine, int num_fila, int mese) {
        double modificatore_mese = 1.0;
        if (mese == 6 || mese == 7 || mese == 9)
            modificatore_mese = 1.5;
        if(mese == 8)
            modificatore_mese = 2.0;
        double totale = (prezzo_lettino*num_lettini+prezzo_sdraio*num_sdraio+prezzo_cabine*num_cabine*(1+(0.1*num_fila))*modificatore_mese;
        return totale;
    }

    @Override
    public boolean getStato(Date data) {
        return false;
    }

    @Override
    public void setStato(Ombrellone ombrellone) {

    }


    @Override
    public void alternaStato() {

    }
}
