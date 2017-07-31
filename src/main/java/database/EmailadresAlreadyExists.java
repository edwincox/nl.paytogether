package database;

public class EmailadresAlreadyExists extends ConnectionDatabase {

    public boolean getUserAccountFromDatabase(String emailadres) throws ClassNotFoundException{
        String SqlStatementDoorgeven=("select emailadres from nawgegevens where emailadres = '" + emailadres + "' ");

        boolean didFoundAMailAdersReadyExists =  selectDatabaseQuery(SqlStatementDoorgeven);

        System.out.println("Does email already exit in the database: " + didFoundAMailAdersReadyExists);
        return didFoundAMailAdersReadyExists;
    }


}
