package database;

import account.AccountCredentials;

import java.sql.*;

public class ConnectionDatabase implements ConfigConnectDatabase {

    private static final java.lang.String CREATECHECKTABEL_NAWGEGEVENS = "CREATE TABLE IF NOT EXISTS nawgegevens (voornaam TEXT,achternaam TEXT,straatnaam TEXT,huisnummer TEXT,postcode TEXT,password TEXT,emailadres TEXT)";

    private void forExterneConnectionConnector() throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
    }


    protected boolean createInsertSqlIntoDatabase(String uitvoerenSqlStatement) throws ClassNotFoundException{

       try {
           forExterneConnectionConnector();
           Connection conn = DriverManager.getConnection(CONNECTION_STRING);
           Statement statement = conn.createStatement();
           createTabelIfNotExistsInDatabase(statement);

           statement.execute(uitvoerenSqlStatement);

           statement.close();
           conn.close();
           return true;
       }catch (SQLException e){
           e.printStackTrace();
           return false;
       }
    }


    private void createTabelIfNotExistsInDatabase(Statement statement) {
        // Hier komen alle sql statement om de checken en aan te maken database tabel wanneer niet bestaat
        System.out.println("Make tabel or check if the tabel's exist");
            try {
                forExterneConnectionConnector();

                statement.execute(CREATECHECKTABEL_NAWGEGEVENS);

                //statement.execute("CREATE TABLE IF NOT EXISTS nawgegevens ( voornaam text,achternaam text,straatnaam text,huisnummer text,postcode text,password text,emailadres text )");
            } catch (SQLException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException c){
                c.printStackTrace();
            }
    }



    protected AccountCredentials getUserFromUsername(String sqlquery) {
        AccountCredentials accountCredentials = null;
        try {
            forExterneConnectionConnector();
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlquery);

            System.out.println("resultset"+ resultSet);
            if (!resultSet.next()){
                System.out.println("we zitten er in");
                return null;
            }

            String voornaam = resultSet.getString("voornaam");
            String achternaam = resultSet.getString("achternaam");
            String straatnaam = resultSet.getString("straatnaam");
            String huisnummer = resultSet.getString("huisnummer");
            String postcode = resultSet.getString("postcode");
            String password = resultSet.getString("password");
            String emailadres = resultSet.getString("emailadres");

            accountCredentials = new AccountCredentials(voornaam, achternaam, straatnaam, huisnummer, postcode, password, emailadres);
            System.out.println("Wat hebben we opgehaald: " + voornaam + achternaam + straatnaam + huisnummer + postcode + password + emailadres);
            statement.close();
            conn.close();
            return accountCredentials;


        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException c){
            c.printStackTrace();
        }


        return accountCredentials;
    }


    protected boolean selectDatabaseQuery(String sqlquery){
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

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