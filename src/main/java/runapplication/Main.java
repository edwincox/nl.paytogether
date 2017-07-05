package runapplication;

import account.AccountCredentials;
import account.PayToGetherApplication;

public class Main {

    public static void main(String[] args){

        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials makeaccount = makeuser.accountForUser("Edwin", "Cox", "Grutto", "14", "5801RG", "", "edje_coxje@hotmail.com");
        System.out.println("MAKE account emailadrs: " + makeaccount.getEmailadres());

//        int aantal = makeuser.getAantalAccount();
//        System.out.println(aantal);
//
//        AccountCredentials getaccount = makeuser.getAccountForUser("edje_coxje@hotmail.com");
//        System.out.println("GET account emailadrs: " + getaccount.getEmailadres());

        //boolean watkomtterug = makeuser.deleteAccountForUser("edje_coxje@hotmail.com");
        //System.out.println("wat komt terug: " + watkomtterug);


    }

}
