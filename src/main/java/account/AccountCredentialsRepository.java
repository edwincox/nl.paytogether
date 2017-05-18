package account;

import java.util.HashMap;
import java.util.Map;

public class AccountCredentialsRepository {

    private Map<String, AccountCredentials> accountcredentials = new HashMap<>();
    private int nextRegistrationNumber = 0;

    public String createAccountForUser(String voornaam, String achternaam, String straatnaam, String huisnummer,
                                       String postcode, String accountnaam, String password, String emailadres)throws AccountAlreadyExistException{

        if (emailadresAlreadyExists(emailadres)){
            System.out.println("Kies een ander username + emailadres");
            throw new AccountAlreadyExistException(emailadres);
        }else {
            String registrationNumber = String.valueOf(getNextRegistrationNumber());
            AccountCredentials user = new AccountCredentials(registrationNumber, voornaam, achternaam, straatnaam, huisnummer, postcode, accountnaam, password, emailadres);
            this.accountcredentials.put(emailadres, user);
            return emailadres;
        }
    }

    public boolean emailadresAlreadyExists(String emailadresControle) {
            AccountCredentials alreadyExitAccount = accountcredentials.get(emailadresControle);

            if (alreadyExitAccount != null) {
                System.out.println("Username en emailadres zijn al bekend in ons systeem");
                return true;
            }
       // }
        return false;
    }

    public AccountCredentials getAccountForUser(String emailadresControle){
        return accountcredentials.get(emailadresControle);
    }

    public void deleteAccountForUser(String accountnumberregistration){
        accountcredentials.remove(accountnumberregistration);
        System.out.println("I have delete number: " + accountnumberregistration);
    }

    private int getNextRegistrationNumber(){
        return nextRegistrationNumber++;
    }
}
