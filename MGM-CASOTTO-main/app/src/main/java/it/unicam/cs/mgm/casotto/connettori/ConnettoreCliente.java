package it.unicam.cs.mgm.casotto.connettori;

import it.unicam.cs.mgm.casotto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnettoreCliente {


    Connection connection;

    public ConnettoreCliente()
    {
        try {
            connection = ConnectDatabase.getConnection();
        } catch (Exception e)
        { System.out.println(e); } //add exception here
    }

    public Cliente getCliente(String email)
    {
        ResultSet result;
        Cliente cliente = new Cliente();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM clienti WHERE email = '" + email + "'");
            while (result.next()) {

                cliente = convertiRisultatoInCliente(result);
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        return cliente;

    }

    private Cliente convertiRisultatoInCliente(ResultSet result) throws SQLException{

            String email = result.getString("email");
            String nome = result.getString("nome");
            String cognome = result.getString("cognome");
            String id_carta = result.getString("id_carta");
            String numero_telefono = result.getString("numero_telefono");


            return new Cliente(email, nome, cognome, id_carta, numero_telefono);
        }

    public boolean addCliente(Cliente cliente) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clienti VALUES ( ?,?,?,?,?)");
            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getCognome());
            preparedStatement.setString(4, cliente.getId_carta());
            preparedStatement.setString(5, cliente.getNumero_telefono());


            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    public boolean AssegnaOmbrellone(String email, String id_ombrellone) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update clienti set id_ombrellone_occupato = ? where email = ?");
            preparedStatement.setString(1, id_ombrellone);
            preparedStatement.setString(2, email);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public List<Cliente> getClienteConOmbrellone() {
        ResultSet result;
        List<Cliente> resultList = new ArrayList<Cliente>();
        try {
            result = connection.createStatement().executeQuery("SELECT * FROM clienti WHERE id_ombrellone_occupato IS NOT NULL");

            while (result.next()) {
                resultList.add(convertiRisultatoInCliente(result));
            }
        } catch (Exception e)
        { System.out.println(e); } //add exception here

        //error checking
        if (resultList.isEmpty())
            System.out.println("Empty result");

        return resultList;
    }

    public boolean rimuoviPrenotazione(String id){
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update clienti set id_ombrellone_occupato = NULL WHERE id_ombrellone_occupato = '"+ id + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean addCarta(String carta, String email) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update clienti set id_carta ='" + carta + "'  WHERE email = '"+ email + "'");
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
}



