package database;

public class GetUserSql extends ConnectionDatabase {

    public boolean getUserAccountFromDatabase(String emailadres) throws ClassNotFoundException{
        //String SqlStatementDoorgeven=("select emailadres from nawgegevens where emailadres = '" + emailadres + "' ");
        String SqlStatementDoorgeven=("select emailadres from nawgegevens where emailadres = '" + emailadres + "'");
        boolean didFoundAMailAdersReadyExists = connectionDatabase(SqlStatementDoorgeven);

        didFoundAMailAdersReadyExists = false;

        System.out.println("Does email already exit in the database: " + didFoundAMailAdersReadyExists);
        return didFoundAMailAdersReadyExists;
    }
}