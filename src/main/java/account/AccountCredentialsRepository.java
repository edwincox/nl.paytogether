package account;

import java.util.HashMap;
import java.util.Map;

public class AccountCredentialsRepository {

    static final Map<String, AccountCredentials> accountcredentials = new HashMap<>();

    public AccountCredentials createNewAccount(String voornaam, String achternaam, String straatnaam, String huisnummer,
                                               String postcode, String password, String emailadres){

        AccountCredentials accountcredentails = new AccountCredentials(voornaam, achternaam, straatnaam, huisnummer, postcode, password, emailadres);

        AccountValidation checkIfAccountDataIsCorrect = new AccountValidation();

        boolean tt = checkIfAccountDataIsCorrect.checkIfAccountIsValid(accountcredentails);

        if (!tt){
            System.out.println("Kies een ander username + emailadres");
            return null;
        }else {
            this.accountcredentials.put(emailadres, accountcredentails);
            return accountcredentails;
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

    public boolean deleteAccountForUser(String emailadres){
        AccountCredentials objectpakken = accountcredentials.remove(emailadres);
        System.out.println("I have delete number: " + emailadres);

        if(objectpakken == null || objectpakken !=null){
            return true;
        }else{
            return false;
        }
    }

    public int aantalAccountInDeList(){
        return accountcredentials.size();
    }

    public int deleteListLikeADatabaseGiveTotalBack(){
        accountcredentials.clear();
        return aantalAccountInDeList();
    }

}