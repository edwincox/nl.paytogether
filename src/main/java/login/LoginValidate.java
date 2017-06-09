package login;

import account.AccountCredentials;
import account.PayToGetherApplication;

public class LoginValidate {

    public boolean loginValidate(String username){

        boolean status;

        PayToGetherApplication person = new PayToGetherApplication();
        AccountCredentials userprofile = person.getAccountForUser(username);

        //if (username.equals(userprofile.getEmailadres())){

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

}