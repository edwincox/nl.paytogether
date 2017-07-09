package login;

import account.AccountCredentials;
import account.PayToGetherApplication;

public class LoginValidate {

    public boolean loginValidate(String username){
        PayToGetherApplication person = new PayToGetherApplication();
        AccountCredentials userprofile = person.getAccountForUser(username);

        boolean status;

        if (userprofile == null) {
            return false;
        }
        String controleEmailAdres = userprofile.getEmailadres();

        if (username.equals(controleEmailAdres) ){
                status=true;
                return status;
            }

        return false;
    }

}