package database;

import java.sql.*;

public class ConnectionDatabase implements ConfigConnectDatabase {


    private static final java.lang.String CREATECHECKTABEL_NAWGEGEVENS = "CREATE TABLE IF NOT EXISTS nawgegevens (voornaam TEXT,achternaam TEXT,straatnaam TEXT,huisnummer TEXT,postcode TEXT,password TEXT,emailadres TEXT)";

    protected boolean connectionDatabase(String uitvoerenSqlStatement) throws ClassNotFoundException {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            makeDatabase(statement);

            statement.execute(uitvoerenSqlStatement);


            statement.close();
            conn.close();

            return true;
            } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
           }
    }

    private void makeDatabase(Statement statement) {
        // Hier komen alle sql statement om de checken en aan te maken database tabel wanneer niet bestaat
        System.out.println("Make tabel or check if the tabel's exist");
            try {
                //statement.execute(CREATECHECKTABEL_NAWGEGEVENS);

                statement.execute("CREATE TABLE IF NOT EXISTS nawgegevens ( voornaam text,achternaam text,straatnaam text,huisnummer text,postcode text,password text,emailadres text )");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    protected boolean selectDatabaseQuery(String sqlquery){
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            System.out.println("Nieuwe query");

            int aantalDoorWhile = 0;
            ResultSet resultSet = statement.executeQuery(sqlquery);
            while (resultSet.next()) {
                String emailadres = resultSet.getString("emailadres");
                System.out.println("done --  "+emailadres + "\n");
                aantalDoorWhile++;
            }
            System.out.println(aantalDoorWhile);


            if (aantalDoorWhile > 0){
                statement.close();
                conn.close();
                return true;
            }

            statement.close();
            conn.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        return true;
        }
    }
}