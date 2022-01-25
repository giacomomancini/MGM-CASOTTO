package it.unicam.cs.mgm.casotto.connettori;

import it.unicam.cs.mgm.casotto.Ordine;
import it.unicam.cs.mgm.casotto.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnettoreOrdine {

    Connection connection;

    public ConnettoreOrdine()
    {

        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e)
        { System.out.println(e); } //add exception here
    }

    public boolean addOrdine(Ordine ordine) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ordini VALUES ( ?,?,?,?)");

            preparedStatement.setInt(1, ordine.getId());
            preparedStatement.setString(2, ordine.getId_prodotto());
            preparedStatement.setString(3, ordine.getId_cliente());
            preparedStatement.setInt(4, ordine.getQuantita());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public List<Ordine> getOrdini() {
        ResultSet result;
        List<Ordine> resultList = new ArrayList<Ordine>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ordini");

            while (result.next()) {
                resultList.add(convertiRisultatoInOrdine(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

    private Ordine convertiRisultatoInOrdine(ResultSet result)throws SQLException
    {
        int id = result.getInt("id");
        String id_prodotto = result.getString("id_prodotto");
        String email = result.getString("id_cliente");
        int quantita = result.getInt("quantita");


        return new Ordine(id, id_prodotto, email, quantita);
    }

    public List<Ordine> getScontrino(String email) {
        ResultSet result;
        List<Ordine> resultList = new ArrayList<Ordine>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ordini WHERE id_cliente ='" + email + "'");

            while (result.next()) {
                resultList.add(convertiRisultatoInOrdine(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }
}
