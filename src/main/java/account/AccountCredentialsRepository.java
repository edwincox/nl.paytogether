package account;

import java.util.HashMap;
import java.util.Map;

public class AccountCredentialsRepository {

    private static final Map<String, AccountCredentials> accountcredentials = new HashMap<>();



    public AccountCredentials createNewAccount(String voornaam, String achternaam, String straatnaam, String huisnummer,
                                               String postcode, String password, String emailadres){

        AccountValidation checkIfAccountDataIsCorrect = new AccountValidation();

        if(!checkIfAccountDataIsCorrect.voornaamCheck(voornaam)){
            return null;
        }

        if(!checkIfAccountDataIsCorrect.passwordValidation(password)){
            return null;
        }

        if (emailadresAlreadyExists(emailadres)){
            System.out.println("Kies een ander username + emailadres");
            return null;
        }else {

            boolean resultaatControleEmailAdresValidati = checkIfAccountDataIsCorrect.usernameValadionCorrectEmailAdres(emailadres);

            if(!resultaatControleEmailAdresValidati){
                return null;
            }
            AccountCredentials user = new AccountCredentials(voornaam, achternaam, straatnaam, huisnummer, postcode, password, emailadres);
            this.accountcredentials.put(emailadres, user);

            //return accountcredentials.get(emailadres);
            return user;
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
}