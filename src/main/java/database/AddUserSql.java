package database;

public class AddUserSql extends ConnectionDatabase {

    public void addUserIntoDatabase(String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String password, String emailadres) throws ClassNotFoundException {

        String SqlStatementDoorgeven=("insert into nawgegevens (voornaam, achternaam, straatnaam, huisnummer, postcode, password, emailadres  ) " +
                    "values('" + voornaam + "'," +
                    " '" + achternaam + "'," +
                    " '" + straatnaam + "'," +
                    " '" + huisnummer + "'," +
                    " '" + postcode + "'," +
                    " '" + password + "'," +
                    " '" + emailadres + " ')");

        connectionDatabase(SqlStatementDoorgeven);
    }
}