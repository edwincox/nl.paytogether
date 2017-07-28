package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {

    public static final String DB_NAME= "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\databases\\" +DB_NAME;

    private static final java.lang.String CREATECHECKTABEL_NAWGEGEVENS = "CREATE TABLE IF NOT EXISTS nawgegevens (edwin text, achternaam text, straatnaam text, huisnummer text, postcode text, password text, emailadres text)";

    protected void connectionDatabase(String uitvoerenSqlStatement) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            makeDatabase(statement);

            statement.execute(" "+ uitvoerenSqlStatement +" ");

            statement.close();
            conn.close();

            } catch (SQLException e1) {
            e1.printStackTrace();
           }
    }

    private void makeDatabase(Statement statement) {
        // Hier komen alle sql statement om de checken en aan te maken database tabel wanneer niet bestaat
        System.out.println("Make tabel or check if the tabel's exist");
            try {
                statement.execute(CREATECHECKTABEL_NAWGEGEVENS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}