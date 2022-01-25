package it.unicam.cs.mgm.casotto;

public class Evento{

    private int id_evento;
    private String nome;
    private String descrizione;
    private String data;
    private int numero_min_partecipanti;
    private int numero_max_partecipanti;
    private int numero_iscritti = 0;

    public Evento(int id, String nome, String descrizione, String data, int minimo_partecipanti, int massimo_partecipanti) {
        this.id_evento = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.numero_min_partecipanti = minimo_partecipanti;
        this.numero_max_partecipanti = massimo_partecipanti;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id_evento='" + id_evento + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", data='" + data + '\'' +
                ", numero_min_partecipanti=" + numero_min_partecipanti +
                ", numero_max_partecipanti=" + numero_max_partecipanti +
                ", numero_iscritti=" + numero_iscritti +
                '}';
    }

    public Evento(String nome, String descrizione, String data, int minimo_partecipanti, int massimo_partecipanti, int iscritti) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.numero_min_partecipanti = minimo_partecipanti;
        this.numero_max_partecipanti = massimo_partecipanti;
        this.numero_iscritti = iscritti;
    }


    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumero_min_partecipanti() {
        return numero_min_partecipanti;
    }

    public void setNumero_min_partecipanti(int numero_min_partecipanti) {
        this.numero_min_partecipanti = numero_min_partecipanti;
    }

    public int getNumero_max_partecipanti() {
        return numero_max_partecipanti;
    }

    public void setNumero_max_partecipanti(int numero_max_partecipanti) {
        this.numero_max_partecipanti = numero_max_partecipanti;
    }

    public int getNumero_iscritti() {
        return numero_iscritti;
    }

    public void setNumero_iscritti(int numero_iscritti) {
        this.numero_iscritti = numero_iscritti;
    }
}
