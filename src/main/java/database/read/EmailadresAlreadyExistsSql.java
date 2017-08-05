package database.read;

import database.ConfigConnectDatabase;

import java.sql.*;

public class EmailadresAlreadyExistsSql implements ConfigConnectDatabase{

    public boolean checkIfEmailadresAlreadyExistsIntoDatabase(String emailadres){

        String runSqlStatement=("select emailadres from nawgegevens where emailadres = '" + emailadres + "'");

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(runSqlStatement);

            if(resultSet.getRow() < 1){
                System.out.println("Mail NIET adres gevonden");
                return false;
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}