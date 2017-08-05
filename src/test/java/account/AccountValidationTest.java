package account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountValidationTest {

    AccountValidation test = new AccountValidation();

    @Test
    public void it_should_test_voornaam_if_it_is_correct_lowercase(){
        boolean controle = test.voornaamCheck("edwin");

        assertThat(controle, is(true));
    }
    @Test
    public void it_should_test_voornaam_if_it_is_correct_uppercase(){
        boolean controle = test.voornaamCheck("EDWIN");

        assertThat(controle, is(true));
    }
    @Test
    public void it_should_test_voornaam_if_it_is_NOT_coorect(){
        boolean controle = test.voornaamCheck("Edwin!");

        assertThat(controle, is(false));
    }

    @Test
    public void it_should_test_voornaam_if_it_is_coorect_whit_other_charaters(){
        boolean controle = test.voornaamCheck("áéíóúýäëïöüÿàèìòùãõñâêîôû");

        assertThat(controle, is(false));
    }

    @Test
    public void it_should_Test_password_less_then_5_karakters_() throws Exception {
    boolean controle = test.passwordValidation("123");
        assertThat(controle, is(false));
    }

    @Test
    public void it_should_Test_password_equeal_OR_more_then_10_karakters_() throws Exception {
        boolean controleExact10 = test.passwordValidation("1234567899");
        boolean controleMoreThen10 = test.passwordValidation("123456789101112");

        assertThat(controleExact10, is(true));
        assertThat(controleMoreThen10, is(true));
    }

    @Test
    public void it_check_if_usernameEmail_addres_already_exist_in_database_it_will_not_exist_in_database() throws Exception{
        PayToGetherApplication makeNewUser = new PayToGetherApplication();
        AccountCredentials accountCredentials = makeNewUser.getAccountForUser("emailnotexistindatabse@hotmail.com");

        assertEquals(accountCredentials, null);
    }

}