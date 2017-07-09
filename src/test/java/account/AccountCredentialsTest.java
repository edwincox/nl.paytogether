package account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountCredentialsTest {

    private String TestAchternaam = "TestAchternaam";
    private String TestVoornaam = "TestVoornaam";
    private String TestStraatnaam = "TestStraatnaam";
    private String TestHuisnummer = "TestHuisnummer";
    private String TestPostcode = "TestPostcode";
    private String TestPasswoord = "TestPasswoord";
    private String TestEmailadres = "TestEmailadres";

    AccountCredentials testcredentials = new AccountCredentials(TestVoornaam, TestAchternaam, TestStraatnaam, TestHuisnummer, TestPostcode, TestPasswoord, TestEmailadres);

    @Test
    public void testGetAchternaam() throws Exception {
        assertThat(testcredentials.getAchternaam(), is(TestAchternaam));
    }

    @Test
    public void testGetVoornaam() throws Exception {
        assertThat(testcredentials.getVoornaam(), is(TestVoornaam));

    }

    @Test
    public void testGetStraatnaam() throws Exception {
        assertThat(testcredentials.getStraatnaam(), is(TestStraatnaam));
    }

    @Test
    public void testGetHuisnummer() throws Exception {
        assertThat(testcredentials.getHuisnummer(), is(TestHuisnummer));
    }

    @Test
    public void testGetPostcode() throws Exception {
        assertThat(testcredentials.getPostcode(), is(TestPostcode));
    }

    @Test
    public void testGetPassword() throws Exception {
        assertThat(testcredentials.getPassword(), is(TestPasswoord));
    }

    @Test
    public void testGetEmailadres() throws Exception {
        assertThat(testcredentials.getEmailadres(), is(TestEmailadres));
    }
}