package runapplication;

import account.AccountCredentials;
import account.PayToGetherApplication;

public class Main {

    public static void main(String[] args){

        // Account aanmaken Test
        PayToGetherApplication makeNewUser = new PayToGetherApplication();
        AccountCredentials accountCredentials = makeNewUser.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "mainrunner_edje_coxje@hotmail.com");

        if(accountCredentials == null){
            System.out.println("Einde programma, omdat email adres al bestaat");
        }

        AccountCredentials accountCredentials1 = makeNewUser.getAccountForUser("mainrunner_edje_coxje@hotmail.com");

        if (accountCredentials1 != null) {
            System.out.println("Voornaam: " + accountCredentials1.getVoornaam());
            System.out.println("Achternaam: " + accountCredentials1.getAchternaam());
            System.out.println("Achternaam: " + accountCredentials1.getStraatnaam());
            System.out.println("Achternaam: " + accountCredentials1.getPostcode());
            System.out.println("Achternaam: " + accountCredentials1.getHuisnummer());
            System.out.println("Achternaam: " + accountCredentials1.getPassword());
            System.out.println("Achternaam: " + accountCredentials1.getEmailadres());
        }


        // Delete emailadres
//    boolean mailAdresVerwijderd = makeNewUser.deleteAccountForUser("mainrunner_edje_coxje@hotmail.com");
//        System.out.println("Is het emailadrs verwijderd? : " +mailAdresVerwijderd);
//        if(mailAdresVerwijderd = true) {
//            System.out.println("Einde, er ging iets fout.");
//        }


        makeNewUser.getAccountForUser("mainrunner_edje_coxje@hotmail.com");
//        AccountService accountService = new AccountService();
//        PayToGetherApplication payToGetherApplication = accountService.addDefaultUser();
//
//        AccountCredentials accountCredentials = payToGetherApplication.getAccountForUser("Rest@hotmail.com");
//        String emailadres = accountCredentials.getEmailadres();
//        System.out.println("Resultaat = " + emailadres);


//        AccountRestService accountRestService = new AccountRestService();
//        PayToGetherApplication voornaam = accountRestService.getDefaultAccounInJSON();
//        System.out.println(voornaam.toString());
//        AccountCredentials vloet = voornaam.getAccountForUser("Rest@hotmail.com");
//        System.out.println(" df "  + vloet.getEmailadres());


//        makeuser.getAccountForUser("edje_coxje@hotmail.com");
//        //System.out.println("aantal account : " + makeuser.getAantalAccount());
//        if(makeaccount != null) {
//            System.out.println("MAKE account emailadrs: " + makeaccount.getEmailadres());
//        }
//
//        PayToGetherApplication makeuser2 = new PayToGetherApplication();
//        AccountCredentials makeaccount2 = makeuser2.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "edje_coxje@hotmail.com");
//
//        System.out.println("aantal account 2.1 : " + makeuser2.getAantalAccount());
//        System.out.println("aantal account 1.2: " + makeuser.getAantalAccount());

//        int aantal = makeuser.getAantalAccount();
//        System.out.println(aantal);
//
//        AccountCredentials getaccount = makeuser.getAccountForUser("edje_coxje@hotmail.com");
//        System.out.println("GET account emailadrs: " + getaccount.getEmailadres());

        //boolean watkomtterug = makeuser.deleteAccountForUser("edje_coxje@hotmail.com");
        //System.out.println("wat komt terug: " + watkomtterug);


    }

}
