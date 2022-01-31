package it.unicam.cs.mgm.casotto;


public class Prodotto implements InterfaceProdotto{

    private String id_prodotto;
    private String nome;
    private double prezzo;
    private int quantita;
    private String marca;
    private String descrizione;
    private String fornitore;

    public Prodotto(String id_prodotto, String nome, String descrizione, int quantita, String fornitore, String marca, double prezzo) {
        this.id_prodotto = id_prodotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.fornitore = fornitore;
        this.marca = marca;
        this.prezzo = prezzo;
    }




    @Override
    public String toString() {
        return ("id_prodotto:"+this.id_prodotto +
                " nome: "+ this.nome +
                " prezzo: " + this.prezzo +
                " quantita : " + this.quantita +
                " marca : " + this.marca +
                " descrizione : " + descrizione +
                " fornitore : " + fornitore);
    }

    public String getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(String id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFornitore() {
        return fornitore;
    }

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }
}
