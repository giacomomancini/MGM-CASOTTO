package it.unicam.cs.mgm.casotto;

public class Spiaggia implements InterfaceSpiaggia {

    private int num_file;
    private int numero_massimo_ombrelloni; //TODO serve?
    private Ombrellone[] spiaggia;

    public Spiaggia(int num_file, int numero_massimo_ombrelloni) {
        this.num_file = num_file;
        this.numero_massimo_ombrelloni = numero_massimo_ombrelloni;
        this.spiaggia = new Ombrellone[numero_massimo_ombrelloni];
    }


    @Override
    public void aggiungiOmbrellone() {

    }

    @Override
    public void eliminaOmbrellone(Ombrellone ombrellone) {

    }
}
