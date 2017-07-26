package account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class AccountCredentialsRepositoryTest {

    @Test
    public void testCreateNewAccount_when_account_not_exist_with_emailadres() throws Exception {
        AccountCredentialsRepository accountCredentialsRepository = new AccountCredentialsRepository();
        accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");
        AccountCredentials accountCredentials = accountCredentialsRepository.getAccountForUser("testAccountCredentialsRepositoryTest@hotmail.com");

        assertNotNull(accountCredentials);
    }

    @Test
    public void testCreateNewAccount_when_account_alleery_exit() throws Exception {
        AccountCredentialsRepository accountCredentialsRepository = new AccountCredentialsRepository();
        accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");
        AccountCredentials accountCredentials2 = accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");

        assertNull(accountCredentials2);
    }


    @Test
    public void testEmailadresAlreadyExists_in_hashmap() throws Exception {
        AccountCredentialsRepository accountCredentialsRepository = new AccountCredentialsRepository();
        accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");
        boolean uitkomstEmailadresAlreadyExists = accountCredentialsRepository.emailadresAlreadyExists("testAccountCredentialsRepositoryTest@hotmail.com");

        assertThat(uitkomstEmailadresAlreadyExists, is(true));
    }

    @Test
    public void testdeleteAccountForUser() throws Exception {
        AccountCredentialsRepository accountCredentialsRepository = new AccountCredentialsRepository();
        accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");

        AccountCredentials accountCredentials2 = accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");
        assertNull(accountCredentials2);

        boolean uitkomstDeleteAccountForUser = accountCredentialsRepository.deleteAccountForUser("testAccountCredentialsRepositoryTest@hotmail.com");
        AccountCredentials accountCredentials = accountCredentialsRepository.getAccountForUser("testAccountCredentialsRepositoryTest@hotmail.com");


        assertThat(uitkomstDeleteAccountForUser, is(true));
        assertNull(accountCredentials);
    }

    @Test
    public void testDeleteListLikeADatabaseGiveTotalBack_make_one_object_check_aantal_if_1_delete_object_check_aantal_if_0(){
        AccountCredentialsRepository accountCredentialsRepository = new AccountCredentialsRepository();
        accountCredentialsRepository.createNewAccount("TestEDWIN", "TestCox", "TestGrutto", "14", "5801RG", "12345678944", "testAccountCredentialsRepositoryTest@hotmail.com");
        int aantalAccountInDeList = accountCredentialsRepository.aantalAccountInDeList();
        assertThat(aantalAccountInDeList, is(1));

        aantalAccountInDeList = accountCredentialsRepository.deleteListLikeADatabaseGiveTotalBack();
        assertThat(aantalAccountInDeList, is(0));
    }


}