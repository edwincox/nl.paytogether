public class PayToGetherApplication {

    public static AccountCredentialsRepository account = new AccountCredentialsRepository();

    public static void main(String[] args){
        System.out.println("Start Application");

// service
        try {


            String emailadres = account.createAccountForUser("Edwin", "Cox", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "edje_coxje@hotmail.com");
            System.out.println("Account1 registratie 1: " + emailadres);

            String registrationNumber2 = account.createAccountForUser("freddie", "Treffer", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "flf@hotmail.com");
            System.out.println("Account2 registratie 2: " + registrationNumber2);

            String registrationNumber3 = account.createAccountForUser("freddie", "Treffer", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "flit@dier.com");
            System.out.println("Account3 registratie 3: " + registrationNumber3);


            // uit gegevens halen
            AccountCredentials gegevens = account.getAccountForUser(emailadres);
            System.out.println("Wat komt er uit : " + gegevens.getAchternaam() );

        }catch(AccountAlreadyExistException e){
            System.out.println();
        }

        // servlet maken waarmee je een account kan aanmaken -- check
        // http post met request parameters , geef je in url mee http://localhost:8080/my-context-root/createAccount?voornaam=Edwin&achternaam=Cox&....
        //succesvol: response code 200 met tekstje "ok!"
        //mislukt: response code 200 met tekstje "email adres bestaat al!"

       // bouwwerk:
       // -servlet schrijven die post opvangt, request params uitleest, administratie bijwerkt, response terugschrijft
       // -web.xml bijwerken zodat de servlet bereikbaar is


        //https://www.tutorialspoint.com/servlets/servlets-packaging.htm
    }

    public void createAccountForUser(String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String username, String passwoord, String emailadres)
            throws AccountAlreadyExistException {
        account.createAccountForUser(voornaam, achternaam, straatnaam, huisnummer, postcode, username, passwoord, emailadres);
    }

    public AccountCredentials getAccountForUser(String emailadres){
        AccountCredentials gegevens = account.getAccountForUser(emailadres);

        account.getAccountForUser(emailadres);
        return new AccountCredentials();
    }

}