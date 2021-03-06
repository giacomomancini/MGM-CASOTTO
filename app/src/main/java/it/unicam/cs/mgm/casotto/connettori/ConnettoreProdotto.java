package it.unicam.cs.mgm.casotto.connettori;

import com.mysql.cj.xdevapi.Result;
import it.unicam.cs.mgm.casotto.Prodotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnettoreProdotto {

    Connection connection;

    public ConnettoreProdotto()
    {
        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e)
        { System.out.println(e); } //add exception here
    }

    public List<Prodotto> getAllProducts()
    {
        ResultSet result;
        List<Prodotto> resultList = new ArrayList<Prodotto>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM products");

            while (result.next()) {
                resultList.add(convertiRisultatoInProdotto(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }

    public boolean updateProdotto(Prodotto prodotto) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update products set nome = ?, descrizione = ?, quantita = ?, fornitore = ?, marca = ?, prezzo = ? where id = ?");
            preparedStatement.setString(1, prodotto.getNome());
            preparedStatement.setString(2, prodotto.getDescrizione());
            preparedStatement.setInt(3, prodotto.getQuantita());
            preparedStatement.setString(4, prodotto.getFornitore());
            preparedStatement.setString(5, prodotto.getMarca());
            preparedStatement.setDouble(6, prodotto.getPrezzo());
            preparedStatement.setString(7, prodotto.getId_prodotto());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public boolean deleteProdotto(String id)
    {
        ResultSet result;
        List<Prodotto> resultList = new ArrayList<Prodotto>();
        try {
            result = connection.createStatement().executeQuery("DELETE FROM products WHERE id = " + id);
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        return true;
    }

    private Prodotto convertiRisultatoInProdotto(ResultSet result) throws SQLException
    {
            String id = result.getString("id");
            String nome = result.getString("nome");
            String descrizione = result.getString("descrizione");
            int quantita = result.getInt("quantita");
            String fornitore = result.getString("fornitore");
            String marca = result.getString("marca");
            Double prezzo = result.getDouble("prezzo");

        return new Prodotto(id, nome, descrizione, quantita, fornitore, marca
                , prezzo);
    }

    public Prodotto getProduct(String id)
    {
        ResultSet result;
       Prodotto prodotto = null;
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM products WHERE id = " + id);

            while (result.next()) {
               prodotto = convertiRisultatoInProdotto(result);
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here
        return prodotto;

    }

    public boolean addProdotto(Prodotto prodotto) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products VALUES ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1, prodotto.getId_prodotto());
            preparedStatement.setString(2, prodotto.getNome());
            preparedStatement.setString(3, prodotto.getDescrizione());
            preparedStatement.setInt(4, prodotto.getQuantita());
            preparedStatement.setString(5, prodotto.getFornitore());
            preparedStatement.setString(6, prodotto.getMarca());
            preparedStatement.setDouble(7, prodotto.getPrezzo());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public double getPrezzoOrdine(String id, int quantita) {
        ResultSet result;
        Prodotto prodotto = null;
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM products WHERE id = " + id);

            while (result.next()) {
                prodotto = convertiRisultatoInProdotto(result);
            }
        } catch (Exception e)
        { System.out.println(e); }
        //add exception here
        return prodotto.getPrezzo()*quantita;
    }
}
