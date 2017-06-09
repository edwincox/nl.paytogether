package RunApp;

import account.AccountCredentials;
import account.AccountCredentialsRepository;

public class main {

    public static void main(String args[]){

        AccountCredentialsRepository account = new AccountCredentialsRepository();
        AccountCredentials terugkomstaccount = account.createAccountForUser("Edwin", "Cox", "Grutto", "22", "5814ag", "edwinpassword", "edje_coxje@hotmail.com");


        System.out.println(
                "Voornaam: " + terugkomstaccount.getVoornaam()
        );

        //AccountCredentialsRepository accountterug = new AccountCredentialsRepository();
        //AccountCredentials teruggeven = accountterug.getAccountForUser(terugkomstaccount.getEmailadres());

        AccountCredentials teruggeven = account.getAccountForUser(terugkomstaccount.getEmailadres());
        System.out.println(
                "Voornaam: " + teruggeven.getVoornaam()
        );

    }

}
