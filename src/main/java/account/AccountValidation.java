package account;

import database.read.EmailadresAlreadyExistsSql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidation extends AccountCredentialsRepository {

    private static final String SPECIAL_CHARS_REGEX_PATTERN = "[" + "-/@#!*$%^&.'_+={}()áéíóúýäëïöüÿàèìòùãõñâêîôû"+ "]+" ;

    public boolean checkIfAccountIsValid(AccountCredentials accountCredentails) {

        boolean checkIfVoornaamIsValid = voornaamCheck(accountCredentails.getVoornaam());
        boolean checkIfPasswordIsValid = passwordValidation(accountCredentails.getPassword());
        boolean checkIfEmailIsValid = emailadresAlreadyExists(accountCredentails.getEmailadres());
        boolean checkIfUsernameValid = usernameValadionCorrectEmailAdres(accountCredentails.getEmailadres());

        return checkIfVoornaamIsValid && checkIfPasswordIsValid && checkIfEmailIsValid && checkIfUsernameValid;
    }

    public boolean voornaamCheck(String voornaam){

        Pattern pattern = Pattern.compile("[a-z][A-Z]]");
        Matcher matcher = pattern.matcher(voornaam);

        if(matcher.find()){
            System.out.println("Voornaam van account is niet correct, false");
            return false;
        }

        Pattern pattern2 = Pattern.compile(SPECIAL_CHARS_REGEX_PATTERN);
        Matcher matcher2 = pattern2.matcher(voornaam);

        if(matcher2.find()){
            System.out.println("Special characters gevonden, niet toegestaan, false");
            return false;
        }
        return true;
    }

    public boolean passwordValidation(String password){

        if(password == null || password.isEmpty() ){
            System.out.println("Password is emtpy, exit program");
            return false;
        }

        if(password.length() < 4 ){
            System.out.println("Password must have less then 4 Characters. You give " + password.length());
            return false;
        }

        return true;
    }

    public boolean emailadresAlreadyExists(String emailadresControle) {

        EmailadresAlreadyExistsSql emailadresAlreadyExists = new EmailadresAlreadyExistsSql();
        System.out.println("emailadresAlreadyExists email adres ophalen: " + emailadresControle);

//        GetUserSql getUserSql = new GetUserSql();
//        System.out.println("emailadresAlreadyExists email adres ophalen: " + emailadresControle);

        AccountCredentials accountCredentials = null;
        boolean antwoordterug = emailadresAlreadyExists.checkIfEmailadresAlreadyExistsIntoDatabase(emailadresControle);

        EmailadresAlreadyExistsSql emailadresAlreadyExistsSql = new EmailadresAlreadyExistsSql();
        boolean ditantwoord = emailadresAlreadyExistsSql.checkIfEmailadresAlreadyExistsIntoDatabase(emailadresControle);

        System.out.println("Debug antwoordterug: " + antwoordterug);
        System.out.println("Debug antwoordterug ditantwoord: " + ditantwoord);

            if (ditantwoord) {
                return false;
            } else {
                return true;
            }


//        AccountCredentials alreadyExitAccount = getAccountForUser(emailadresControle);
//
//        if (alreadyExitAccount != null) {
//            System.out.println("Username en emailadres zijn al bekend in ons systeem");
//            return false;
//        }
//        // }
//        return true;
    }

    public boolean usernameValadionCorrectEmailAdres(String emailadres){

        boolean bevatStringHetAtTeken = emailadres.contains("@");

        if(bevatStringHetAtTeken == false ){
            return false;
        }

        boolean bevatEmailAdesEenPunt = emailadres.contains(".");

        if(bevatEmailAdesEenPunt == false){
            return false;
        }

        return true;
    }
}