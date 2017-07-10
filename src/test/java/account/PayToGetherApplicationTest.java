package account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by edwincox on 9-7-2017.
 */
public class PayToGetherApplicationTest {



    @Test
    public void create_new_user_get_object_back_AND_getaantal_in_hashmap_must_be_one() throws Exception {
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials makeaccount = makeuser.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "piet99@hotmail.com");

        assertNotNull(makeaccount); // Er moet een object terug komen geen null
    }

    @Test
    public void get_account_for_user_out_of_the_hashmap() throws Exception {
        PayToGetherApplication makeuser11 = new PayToGetherApplication();
        makeuser11.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "edje_coxje@hotmail.com");
        AccountCredentials getObjectWhiteAccountBack = makeuser11.getAccountForUser("edje_coxje@hotmail.com");

        assertNotNull(getObjectWhiteAccountBack); // Er moet een object terug komen geen null
    }

    @Test
    public void get_one_user_out_hashmap(){
        PayToGetherApplication makeuser10 = new PayToGetherApplication();
        makeuser10.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "edje_coxje12@hotmail.com");

        int aantalInHashmap = makeuser10.getAantalAccount();
        assertThat(aantalInHashmap, is(1)); // er moet 1 account\object in hashmap zitten
    }
    @Test
    public void testDeleteAccountForUser() throws Exception {

    }

    @Test
    public void get_5_user_out_hashmap() throws Exception {
        PayToGetherApplication makeuser = new PayToGetherApplication();
        makeuser.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "piet@hotmail.com");

        PayToGetherApplication makeuser1 = new PayToGetherApplication();
        makeuser1.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "piet1@hotmail.com");

        PayToGetherApplication makeuser2 = new PayToGetherApplication();
        makeuser2.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "piet2@hotmail.com");

        PayToGetherApplication makeuser3 = new PayToGetherApplication();
        makeuser3.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "piet3@hotmail.com");

        PayToGetherApplication makeuser4 = new PayToGetherApplication();
        makeuser4.createNewAccountForUser("EDWIN", "Cox", "Grutto", "14", "5801RG", "12345678944", "piet4@hotmail.com");


        PayToGetherApplication makeuser5 = new PayToGetherApplication();
        int aantalInHashmap = makeuser5.getAantalAccount();
        System.out.println("Aantal:" + aantalInHashmap);
        assertThat(aantalInHashmap, is(5)); // er moet 1 account\object in hashmap zitten
    }
}