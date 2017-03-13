public class PayToGetherApplication {

    private static AccountCredentialsRepository account = new AccountCredentialsRepository();

    public static void main(String[] args){
        System.out.println("Start Application");

// service

        try {


            String registrationNumber = account.createAccountForUser("Edwin", "Cox", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "edje_coxje@hotmail.com");
            System.out.println("Account1 registratie: " + registrationNumber);

            String registrationNumber2 = account.createAccountForUser("freddie", "Treffer", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "edje_coxje@hotmail.com");
            System.out.println("Account2 registratie: " + registrationNumber2);

            String registrationNumber3 = account.createAccountForUser("freddie", "Treffer", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "flit@dier.com");
            System.out.println("Account3 registratie: " + registrationNumber3);

        }catch(AccountAlreadyExistException e){
            System.out.println(e);
        }
        // servlet maken waarmee je een account kan aanmaken
        // http post met request parameters , geef je in url mee http://localhost:8080/my-context-root/createAccount?voornaam=Edwin&achternaam=Cox&....
        //succesvol: response code 200 met tekstje "ok!"
        //mislukt: response code 200 met tekstje "email adres bestaat al!"

       // bouwwerk:
       // -servlet schrijven die post opvangt, request params uitleest, administratie bijwerkt, response terugschrijft
       // -web.xml bijwerken zodat de servlet bereikbaar is


        //https://www.tutorialspoint.com/servlets/servlets-packaging.htm
    }
}