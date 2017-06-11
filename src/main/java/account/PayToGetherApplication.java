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

    public boolean deleteAccountForUser(String emailadres){
        AccountCredentials gegevens = account.getAccountForUser(emailadres);

        if (gegevens == null){
            System.out.println("Email adres bestaat niet done.");
            return false;
        }

        boolean terug = account.deleteAccountForUser(gegevens.getEmailadres());

        if (terug){
            System.out.println("Prima");
            return true;
        }

        AccountCredentials controleDaadwerkijkVerwijderd = account.getAccountForUser(emailadres);

        if (controleDaadwerkijkVerwijderd == null){
            return false;
        }

        return false;
    }
}