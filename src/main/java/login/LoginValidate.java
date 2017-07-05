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

    public boolean passwordValidation(String username, String password){
        if(password == null || password.isEmpty() ){
            System.out.println("Password is emtpy, exit programme");
            return true;
        }
        return false;
    }
}