package database.delete;

import database.ConfigConnectDatabase;
import database.read.EmailadresAlreadyExistsSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUserSql implements ConfigConnectDatabase {

    public boolean deleteEmailAdresForUserWithEmailadres(String emailadresAccount){

        String runSqlStatement=("delete from nawgegevens where emailadres = '" + emailadresAccount + "'");

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate(runSqlStatement);

            EmailadresAlreadyExistsSql emailadresAlreadyExists = new EmailadresAlreadyExistsSql();
            boolean doesEmailStillExistInDatabase = emailadresAlreadyExists.checkIfEmailadresAlreadyExistsIntoDatabase(emailadresAccount);



            if (doesEmailStillExistInDatabase = true) {
                return false;
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}