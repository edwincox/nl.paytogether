package database.update;

import database.ConfigConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditUserSql implements ConfigConnectDatabase {

    public boolean editUserAccountInDatabase(String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String emailadres){

        String runSqlStatement=("update nawgegevens set "
                + "voornaam ='" + voornaam + "'"
                + ", achternaam ='" + achternaam + "'"
                + ", straatnaam ='" + straatnaam + "'"
                + ", huisnummer ='" + huisnummer + "'"
                + ", postcode ='" + postcode + "'" +
        " where emailadres='" + emailadres + "'");

        System.out.println("Update de volgende gegevens in de database voor account " + emailadres + " met de volgende gegevens: : " + voornaam + achternaam + straatnaam + huisnummer + postcode);

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate(runSqlStatement);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}