package account;


public class PayToGetherApplication {

    public static AccountCredentialsRepository repository = new AccountCredentialsRepository();

    public AccountCredentials createNewAccountForUser(String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String passwoord, String emailadres){
        AccountCredentials accountCredentials = repository.createNewAccount(voornaam, achternaam, straatnaam, huisnummer, postcode, passwoord, emailadres);
        return accountCredentials;
    }

    public AccountCredentials getAccountForUser(String emailadres){
        AccountCredentials gegevens = repository.getAccountForUser(emailadres);
        return gegevens;
    }


    public boolean deleteAccountForUser(String emailadres){

        AccountCredentials opgehaaldAccount = repository.getAccountForUser(emailadres);

        if (opgehaaldAccount == null){
            System.out.println("Email adres bestaat niet, in de list.");
            return false;
        }

        //boolean terug = repository.deleteAccountForUser(opgehaaldAccount.getEmailadres());
        boolean terug = repository.deleteAccountForUser(emailadres);

        if (terug){
            System.out.println("Account succesvol verwijderd");
            return true;
        }

        AccountCredentials controleDaadwerkijkVerwijderd = repository.getAccountForUser(emailadres);

        if (controleDaadwerkijkVerwijderd == null){
            System.out.println("Account niet kunnen ophalen");
            return false;
        }

        return false;
    }

    public int getAantalAccount(){
        return repository.aantalAccountInDeList();
    }

    public int emptyTheListLikeTheDatabase(){
        return repository.deleteListLikeADatabaseGiveTotalBack();
    }
}