package database.read;

import account.AccountCredentials;
import database.ConfigConnectDatabase;

import java.sql.*;

public class GetUserSql implements ConfigConnectDatabase {

    public AccountCredentials getUserAccountFromDatabase(String getEmailadresForThisAccount) throws ClassNotFoundException{

        String runSqlStatement=("select * from nawgegevens where emailadres = '" + getEmailadresForThisAccount + "'");

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(runSqlStatement);

            while(resultSet.next()) {
                String voornaam = resultSet.getString("voornaam");
                String achternaam = resultSet.getString("achternaam");
                String straatnaam = resultSet.getString("straatnaam");
                String huisnummer = resultSet.getString("huisnummer");
                String postcode = resultSet.getString("postcode");
                String password = resultSet.getString("password");
                String emailadres = resultSet.getString("emailadres");

                // check of het opgehaald email adres het zelfde is
                if(!getEmailadresForThisAccount.equals(emailadres)) {
                    return null;
                }

                AccountCredentials accountCredentials = new AccountCredentials(voornaam, achternaam, straatnaam, huisnummer, postcode, password, emailadres);
                System.out.println("Wat hebben we opgehaald: " + voornaam + achternaam + straatnaam + huisnummer + postcode + password + emailadres);
                statement.close();
                conn.close();
                return accountCredentials;

            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}