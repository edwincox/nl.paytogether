package account;

public class AccountCredentials {

    private String registrationNumber;
    private String voornaam;
    private String achternaam;
    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String password;
    private String emailadres;

    public AccountCredentials(String registrationNumber, String voornaam, String achternaam, String straatnaam, String huisnummer, String postcode, String password, String emailadres) {
        this.registrationNumber = registrationNumber;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.password = password;
        this.emailadres = emailadres;
    }

    public String getRegistrationNumber(){ return registrationNumber;}

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailadres() {
        return emailadres;
    }
}
