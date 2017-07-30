package database;

import java.sql.*;

public class ConnectionDatabase {

    public static final String DB_NAME= "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\databases\\" +DB_NAME;

    private static final java.lang.String CREATECHECKTABEL_NAWGEGEVENS = "CREATE TABLE IF NOT EXISTS nawgegevens (voornaam TEXT,achternaam TEXT,straatnaam TEXT,huisnummer TEXT,postcode TEXT,password TEXT,emailadres TEXT)";

    protected boolean connectionDatabase(String uitvoerenSqlStatement) throws ClassNotFoundException {
        try {
            //Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            makeDatabase(statement);

            statement.execute(uitvoerenSqlStatement);
            //ResultSet resultSet = statement.executeQuery(uitvoerenSqlStatement);

            //ResultSet resultSet = statement.executeQuery("select * from nawgegevens where voornaam = 'EDWIN'");

            System.out.println("nu");
            System.out.println("statement: " + uitvoerenSqlStatement);
//            while (resultSet.next()) {
//                String emailadres = resultSet.getString("emailadres");
//                System.out.println("done --  "+emailadres + "\n");
//            }
            System.out.println("einde");


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
}