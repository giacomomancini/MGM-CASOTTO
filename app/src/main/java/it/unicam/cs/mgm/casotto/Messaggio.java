package it.unicam.cs.mgm.casotto;

public class Messaggio {
    int id;
    String id_mittente;
    String id_destinatario;
    String testo;

    public Messaggio(int id, String id_mittente, String id_destinatario, String testo) {
        this.id = id;
        this.id_mittente = id_mittente;
        this.id_destinatario = id_destinatario;
        this.testo = testo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_mittente() {
        return id_mittente;
    }

    public void setId_mittente(String id_mittente) {
        this.id_mittente = id_mittente;
    }

    public String getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(String id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public String toString() {
        return "Messaggio{" +
                "id_mittente='" + id_mittente + '\'' +
                ", testo='" + testo + '\'' +
                '}';
    }
}
