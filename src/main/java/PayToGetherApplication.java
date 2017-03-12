public class PayToGetherApplication {

    private static AccountCredentialsRepository account = new AccountCredentialsRepository();

    public static void main(String[] args){
        System.out.println("Start Application");

// service
        String registrationNumber = account.createAccountForUser("Edwin", "Cox", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "edje_coxje@hotmail.com");
        System.out.println("Account1 registratie: " + registrationNumber);

        String registrationNumber2 = account.createAccountForUser("freddie", "Treffer", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "edje_coxje@hotmail.com");
        System.out.println("Account2 registratie: " + registrationNumber2);

        String registrationNumber3 = account.createAccountForUser("freddie", "Treffer", "Drabbelsweg", "6", "5814ag", "iceman", "password123", "flit@dier.com");
        System.out.println("Account3 registratie: " + registrationNumber3);


        // bestaat email adres dan geef ikk melding terug username en email bekend --> done
        // mijn registratie emailadres wordt mijn key --> done

        // mavean project packaging war
        // C:\temp\apache-tomcat-8.5.11\webapps   in de webapps directory maken
        // war maken
        // tomcat kan plaatsen
        // servlet maken die naar een http request kan luisteren

    }
}