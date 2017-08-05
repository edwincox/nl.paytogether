package account;

import database.create.AddUserSql;
import database.delete.DeleteUserSql;
import database.read.EmailadresAlreadyExistsSql;
import database.read.GetUserSql;

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

            AddUserSql addUserSql = new AddUserSql();

            try {
                addUserSql.addUserIntoDatabase(voornaam, achternaam, straatnaam, huisnummer, postcode, password, emailadres);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return accountcredentails;
        }
    }

    public boolean emailadresAlreadyExists(String emailadresControle) {
        AccountCredentials alreadyExitAccount = accountcredentials.get(emailadresControle);

        //GetUserSql getUserSql = new GetUserSql();
        EmailadresAlreadyExistsSql emailadresAlreadyExists = new EmailadresAlreadyExistsSql();
        System.out.println("emailadresAlreadyExists email adres ophalen: " + emailadresControle);

        AccountCredentials accountCredentials = null;

            boolean watishet = emailadresAlreadyExists.checkIfEmailadresAlreadyExistsIntoDatabase(emailadresControle);
            if (watishet = true) {
                return true;
            } else {
                return false;
            }


//        if (alreadyExitAccount != null) {
//                System.out.println("Username en emailadres zijn al bekend in ons systeem");
//                return true;
//            }
//        return false;
    }

    public AccountCredentials getAccountForUser(String emailadresControle){
        GetUserSql getUserSql = new GetUserSql();
        System.out.println("Welk email adres gaan we get (ophalen): " + emailadresControle);
        try {
            AccountCredentials accountCredentials = getUserSql.getUserAccountFromDatabase(emailadresControle);

            return accountCredentials;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteAccountForUser(String emailadres){
        //AccountCredentials objectpakken = accountcredentials.remove(emailadres);
        System.out.println("Account for user wil be delete with account: " + emailadres);

        DeleteUserSql deleteUserSql = new DeleteUserSql();

        boolean isAccountSuccevolDelete = deleteUserSql.deleteEmailAdresForUserWithEmailadres(emailadres);

        if (isAccountSuccevolDelete = true){
            return true;
        }else{
            return false;
        }

//        if(objectpakken == null || objectpakken !=null){
//            System.out.println("Er is een object aanwezig in de hashmap");
//            return true;
//        }else{
//            System.out.println("Er zijn geen objecten meer in de hashmap");
//            return false;
//        }
    }

    public int aantalAccountInDeList(){
        return accountcredentials.size();
    }

    public int deleteListLikeADatabaseGiveTotalBack(){
        accountcredentials.clear();
        return aantalAccountInDeList();
    }

}