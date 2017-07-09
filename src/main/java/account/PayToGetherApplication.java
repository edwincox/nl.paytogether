package account;


public class PayToGetherApplication {

    public static AccountCredentialsRepository account = new AccountCredentialsRepository();

    public AccountCredentials createNewAccountForUser(String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String passwoord, String emailadres){
        AccountCredentials accountCredentials = account.createNewAccount(voornaam, achternaam, straatnaam, huisnummer, postcode, passwoord, emailadres);
        return accountCredentials;
    }

    public AccountCredentials getAccountForUser(String emailadres){
        AccountCredentials gegevens = account.getAccountForUser(emailadres);
        return gegevens;
    }

    public boolean deleteAccountForUser(String emailadres){
        AccountCredentials opgehaaldAccount = account.getAccountForUser(emailadres);

        if (opgehaaldAccount == null){
            System.out.println("Email adres bestaat niet, in de list.");
            return false;
        }

        boolean terug = account.deleteAccountForUser(opgehaaldAccount.getEmailadres());

        if (terug){
            System.out.println("Account succesvol opgehaald");
            return true;
        }

        AccountCredentials controleDaadwerkijkVerwijderd = account.getAccountForUser(emailadres);

        if (controleDaadwerkijkVerwijderd == null){
            System.out.println("Account niet kunnen ophalen");
            return false;
        }

        return false;
    }

    public int getAantalAccount(){
        return account.aantalAccountInDeList();
    }
}