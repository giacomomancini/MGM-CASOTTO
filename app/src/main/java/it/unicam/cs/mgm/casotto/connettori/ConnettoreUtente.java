package it.unicam.cs.mgm.casotto.connettori;

import it.unicam.cs.mgm.casotto.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnettoreUtente {

    Connection connection;

    public ConnettoreUtente()
    {
        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e)
        { System.out.println(e); } //add exception here
    }

    public boolean registrazione(String username, String password) {

        boolean result;

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utenti VALUES ( ?,?,?)");
            preparedStatement.setString(1, username.trim());
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, 1);

            result = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public Utente login(String username, String password) {

        ResultSet result;
        Utente utente = new Utente();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM utenti WHERE username ='" + username + "' AND password = '" + password + "'");

            while (result.next()) {
                utente = convertiRisultatoInUtente(result);
            }
        } catch (Exception e)
        { System.out.println(e); }

        return utente;
    }


    private Utente convertiRisultatoInUtente(ResultSet result) throws SQLException {
        String username = result.getString("username");
        String password = result.getString("password");
        int privileges = result.getInt("privileges");


        return new Utente( username, password, privileges);
    }

    public List<Utente> getClienti() {
        ResultSet result;
        List<Utente> resultList = new ArrayList<Utente>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM utenti WHERE privileges =" + 1);

            while (result.next()) {
                resultList.add(convertiRisultatoInUtente(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

    public boolean aggiornaRuolo(String email, int ruolo) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update utenti set privileges =" + ruolo + " WHERE username = '" + email + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public List<Utente> getDipendenti() {
        ResultSet result;
        List<Utente> resultList = new ArrayList<Utente>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM utenti WHERE privileges !=" + 1);

            while (result.next()) {
                resultList.add(convertiRisultatoInUtente(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

    public boolean LicenziaDipendente(String email) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update utenti set privileges =" + 1 + " WHERE username = '" + email + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
}

