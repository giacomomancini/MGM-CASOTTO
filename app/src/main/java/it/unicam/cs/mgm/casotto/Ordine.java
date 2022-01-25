package it.unicam.cs.mgm.casotto;

public class Ordine {
    int id;
    String id_prodotto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(String id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    String id_cliente;
    int quantita;

    public Ordine(int id, String id_prodotto, String id_cliente, int quantita) {
        this.id = id;
        this.id_prodotto = id_prodotto;
        this.id_cliente = id_cliente;
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", id_prodotto='" + id_prodotto + '\'' +
                ", id_cliente='" + id_cliente + '\'' +
                ", quantita=" + quantita +
                '}';
    }
}
