package it.unicam.cs.mgm.casotto.connettori;

import it.unicam.cs.mgm.casotto.Messaggio;
import it.unicam.cs.mgm.casotto.Prodotto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnettoreMessaggi {
    Connection connection;

    public ConnettoreMessaggi() {
        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here
    }

    public boolean addMessaggio(Messaggio messaggio) {
        boolean result;
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement("INSERT INTO messaggi VALUES (NULL,?,?,?)");
            preparedStatement.setString(1, messaggio.getId_mittente());
            preparedStatement.setString(2, messaggio.getId_destinatario());
            preparedStatement.setString(3, messaggio.getTesto());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public List<Messaggio> leggiMessaggi(String email)
    {
        ResultSet result;
        List<Messaggio> resultList = new ArrayList<Messaggio>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM messaggi WHERE id_destinatario = '" + email+ "'");

            while (result.next()) {
                resultList.add(convertiRisultatoInMessaggio(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }

    private Messaggio convertiRisultatoInMessaggio(ResultSet result) throws SQLException {
        int id = result.getInt("idMessaggi");
        String id_mittente = result.getString("id_mittente");
        String id_destinatario = result.getString("id_destinatario");
        String testo = result.getString("testo");


        return new Messaggio(id, id_mittente, id_destinatario, testo);
    }
}
