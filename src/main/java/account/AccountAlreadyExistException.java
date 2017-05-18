package account;

public class AccountAlreadyExistException extends Exception {

    private String faultEmailAdres;

    public AccountAlreadyExistException(String emailadres) {
        this.faultEmailAdres = emailadres;
    }

    public String getFaultEmailAdres() {
        return faultEmailAdres;
    }
}
