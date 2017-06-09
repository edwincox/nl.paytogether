package account;

public class PayToGetherApplication {

    public static AccountCredentialsRepository account = new AccountCredentialsRepository();

    public AccountCredentials accountForUser(String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String passwoord, String emailadres){
        AccountCredentials gegevens = account.createAccountForUser(voornaam, achternaam, straatnaam, huisnummer, postcode, passwoord, emailadres);
        return gegevens;
    }

    public AccountCredentials getAccountForUser(String emailadres){
        AccountCredentials gegevens = account.getAccountForUser(emailadres);
        return gegevens;
    }

}