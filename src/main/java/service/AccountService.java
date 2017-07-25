package service;

import account.PayToGetherApplication;

public class AccountService {

    public PayToGetherApplication addDefaultUser(){
        PayToGetherApplication payToGetherApplication = new PayToGetherApplication();
        payToGetherApplication.createNewAccountForUser("RestEDWIN", "RestCox", "RestGrutto", "Rest14", "Rest5801RG", "12345678944", "Rest@hotmail.com");
        return payToGetherApplication;
    }

    public PayToGetherApplication getAccountGegevens(){
        PayToGetherApplication payToGetherApplication = new PayToGetherApplication();
        payToGetherApplication.getAccountForUser("Rest@hotmail.com");

        return payToGetherApplication;
    }
}