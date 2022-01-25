package it.unicam.cs.mgm.casotto.connettori;
import it.unicam.cs.mgm.casotto.Ombrellone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnettoreOmbrellone  {

    Connection connection;

    public ConnettoreOmbrellone()
    {
        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e)
        { System.out.println(e); } //add exception here
    }

    public List<Ombrellone> getAllOmbrelloni()
    {
        ResultSet result;
        List<Ombrellone> resultList = new ArrayList<Ombrellone>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ombrelloni");

            while (result.next()) {
                resultList.add(convertiRisultatoInOmbrellone(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }

    private Ombrellone convertiRisultatoInOmbrellone(ResultSet result) throws SQLException {
        String id = result.getString("id");
        int fila = result.getInt("fila");
        double prezzo = result.getDouble("prezzo");
        String QRCode = result.getString("QRCode");
        int numero_lettini = result.getInt("numero_lettini");
        int numero_sdraie = result.getInt("numero_sdraie");
        int numero_cabine = result.getInt("numero_cabine");
        int numero_ospiti = result.getInt("numero_ospiti");

        return new Ombrellone(id, fila, prezzo, QRCode, numero_lettini, numero_sdraie, numero_cabine, numero_ospiti);
    }

    public List<Ombrellone> getAvailableOmbrelloni(int numero_ospiti) {
        ResultSet result;
        List<Ombrellone> resultList = new ArrayList<Ombrellone>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ombrelloni WHERE stato = '1' AND numero_ospiti >= " + numero_ospiti);

            while (result.next()) {
                resultList.add(convertiRisultatoInOmbrellone(result));
            }
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Non ci sono ombrelloni disponibili");

        return resultList;

    }
    public boolean setOmbrelloneOccupato(String id) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update ombrelloni set stato = 0 WHERE id = '"+ id + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
    public boolean liberaOmbrellone(String id) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update ombrelloni set stato = 1 WHERE id = '"+ id + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public List<Ombrellone> getOmbrelloniOccupati() {
        ResultSet result;
        List<Ombrellone> resultList = new ArrayList<Ombrellone>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM ombrelloni WHERE stato = '0'");

            while (result.next()) {
                resultList.add(convertiRisultatoInOmbrellone(result));
            }
        } catch (Exception e) {
            System.out.println(e);
        } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

    public boolean AddOmbrellone(Ombrellone ombrellone) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ombrelloni VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, ombrellone.getId());
            preparedStatement.setInt(2, ombrellone.getNum_fila());
            preparedStatement.setDouble(3, ombrellone.getPrezzo());
            preparedStatement.setBoolean(4, false);
            preparedStatement.setString(5, ombrellone.getQRCode());
            preparedStatement.setInt(6, ombrellone.getNumero_lettini());
            preparedStatement.setInt(7, ombrellone.getNumero_sdraie());
            preparedStatement.setInt(8, ombrellone.getNumero_cabine());
            preparedStatement.setInt(9, ombrellone.getNum_ospiti());

            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public boolean modificaPrezzo(double totale, String id) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update ombrelloni set prezzo =" +totale +" WHERE id = '" + id + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
    public List<Double> getPrezzi()
    {
        ResultSet result;
        List<Double> resultList = new ArrayList<Double>();
        try {
            result = connection.createStatement().executeQuery("SELECT prezzo FROM ombrelloni");

            while (result.next()) {
                resultList.add(convertiRisultatoInPrezzo(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;

    }

    private double convertiRisultatoInPrezzo(ResultSet result) throws SQLException {
        double prezzo = result.getDouble("prezzo");
        return prezzo;
    }

    public double getPrezzo(String id) {
        ResultSet result;
        double prezzo = 0;
        try {
            result = connection.createStatement().executeQuery("SELECT prezzo FROM ombrelloni WHERE id = " + id);

            while (result.next()) {
                prezzo = (convertiRisultatoInPrezzo(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking


        return prezzo;

    }
}

