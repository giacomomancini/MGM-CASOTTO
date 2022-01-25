package it.unicam.cs.mgm.casotto.connettori;

import it.unicam.cs.mgm.casotto.Evento;
import it.unicam.cs.mgm.casotto.Ombrellone;
import it.unicam.cs.mgm.casotto.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnettoreEvento {
    Connection connection;

    public ConnettoreEvento()
    {
        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e)
        { System.out.println(e); } //add exception here
    }

    public List<Evento> getAllEventi()
    {
        ResultSet result;
        List<Evento> resultList = new ArrayList<Evento>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM events");

            while (result.next()) {
                resultList.add(convertiRisultatoInEvento(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }

    private Evento convertiRisultatoInEvento(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("Nome");
        String descrizione = result.getString("Descrizione");
        String data = result.getString("Data");
        int minimo_partecipanti = result.getInt("numero_min_partecipanti");
        int massimo_partecipanti = result.getInt("numero_max_partecipanti");
        return new Evento(id, nome, descrizione, data, minimo_partecipanti, massimo_partecipanti);
    }

    public boolean addEvento(Evento evento) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO events VALUES ( NULL,?,?,?,?,?,?)");
            preparedStatement.setString(1, evento.getNome());
            preparedStatement.setString(2, evento.getDescrizione());
            preparedStatement.setString(3, evento.getData());
            preparedStatement.setInt(4, evento.getNumero_min_partecipanti());
            preparedStatement.setInt(5, evento.getNumero_max_partecipanti());
            preparedStatement.setInt(6, evento.getNumero_iscritti());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public boolean updateEvento(Evento evento) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update events set Nome = ?, Descrizione = ?, Data = ?, Numero_min_partecipanti = ?, Numero_max_partecipanti = ? where id = ?");
            preparedStatement.setString(1,evento.getNome());
            preparedStatement.setString(2, evento.getDescrizione());
            preparedStatement.setString(3, evento.getData());
            preparedStatement.setInt(4, evento.getNumero_min_partecipanti());
            preparedStatement.setInt(5, evento.getNumero_max_partecipanti());
            preparedStatement.setInt(6, evento.getId_evento());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public void deleteEvento(int id) {
        try {
            connection.createStatement().execute("DELETE FROM events WHERE id = " + id);
        } catch (Exception e)
        { System.out.println(e); } //add exception here

    }

    public Evento getEvento(int id) {
        ResultSet result;
        Evento evento = null;
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM events WHERE id = " + id);

            while (result.next()) {
                evento = convertiRisultatoInEvento(result);
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here
        return evento;
    }


    public List<Evento> getEventiDisponibili()
    {
        ResultSet result;
        List<Evento> resultList = new ArrayList<Evento>();
        try {
                result = connection.createStatement().executeQuery("SELECT * FROM events WHERE Numero_iscritti < Numero_max_partecipanti");

            while (result.next()) {
                resultList.add(convertiRisultatoInEvento(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }
    public int getNumeroIscritti (int id){
        ResultSet result;
        int numero_iscritti = 0;
        try {
            result = connection.createStatement().executeQuery("SELECT Numero_iscritti FROM events WHERE id = " + id);

            while (result.next()) {
                numero_iscritti = convertiRisultatoInIscritti(result);
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here
        return numero_iscritti;
    }

    private int convertiRisultatoInIscritti(ResultSet result)throws SQLException {
        int iscritti = result.getInt("Numero_iscritti");
        return iscritti;
    }

    public void AggiornaIscritti(int iscritti, int id) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update events set Numero_iscritti = " + iscritti + " where id = "+ id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
    }

}
