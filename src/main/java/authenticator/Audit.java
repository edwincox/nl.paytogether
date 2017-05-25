package authenticator;

import account.AccountCredentials;
import account.AccountCredentialsRepository;
import account.PayToGetherApplication;

public class Audit {

    private AccountCredentialsRepository accountCredentialsRepository;

    public String authenticate(String emailadres, String password) {

        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials object =  makeuser.getAccountForUser(emailadres);

        if (object != null && password.equals(object.getPassword())) {
            return "success";
        }
        return "failure";
    }
}