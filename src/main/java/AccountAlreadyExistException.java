/**
 * Created by CoxEGTPH on 13-3-2017.
 */
public class AccountAlreadyExistException extends Exception {

    private String faultEmailAdres;

    public AccountAlreadyExistException(String emailadres) {
        this.faultEmailAdres = emailadres;
    }

    public String getFaultEmailAdres() {
        return faultEmailAdres;
    }
}
