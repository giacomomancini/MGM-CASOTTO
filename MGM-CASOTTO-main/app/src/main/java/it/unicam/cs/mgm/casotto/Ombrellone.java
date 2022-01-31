package it.unicam.cs.mgm.casotto;

public class Ombrellone implements InterfaceOmbrellone {

    private int num_fila;
    private double prezzo;
    private String id;
    private int num_ospiti;
    private String QRCode;
    private boolean isFree = true;
    private int numero_sdraie;
    private int numero_lettini;
    private int numero_cabine;




    public Ombrellone(String id, int num_fila, double prezzo, String QRCode, int num_lettini, int num_sdraie, int num_cabine, int num_ospiti) {
        this.num_fila = num_fila;
        this.prezzo = prezzo;
        this.id = id;
        this.num_ospiti = num_ospiti;
        this.QRCode = QRCode;
        this.numero_lettini = num_lettini;
        this.numero_sdraie = num_sdraie;
        this.numero_cabine = num_cabine;


    }

    public String toString() {
        return ("id:"+this.id +
                " fila: "+ this.num_fila +
                " prezzo: " + this.prezzo +
                " numero ospiti : " + this.num_ospiti +
                " QRCode : " + this.QRCode +
                " numero sdraie : " + this.numero_sdraie +
                " numero lettini : " + this.numero_lettini +
                "numero cabine : " + this.numero_cabine);
    }



    public int getNum_fila() {
        return num_fila;
    }

    public void setNum_fila(int num_fila) {
        this.num_fila = num_fila;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum_ospiti() {
        return num_ospiti;
    }

    public void setNum_ospiti(int num_ospiti) {
        this.num_ospiti = num_ospiti;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getNumero_sdraie() {
        return numero_sdraie;
    }

    public void setNumero_sdraie(int numero_sdraie) {
        this.numero_sdraie = numero_sdraie;
    }

    public int getNumero_lettini() {
        return numero_lettini;
    }

    public void setNumero_lettini(int numero_lettini) {
        this.numero_lettini = numero_lettini;
    }

    public int getNumero_cabine() {
        return numero_cabine;
    }

    public void setNumero_cabine(int numero_cabine) {
        this.numero_cabine = numero_cabine;
    }
}
