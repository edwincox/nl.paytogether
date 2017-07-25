package rest;


import account.PayToGetherApplication;
import service.AccountService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class AccountRestService {

    @Path("/users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PayToGetherApplication getDefaultAccounInJSON(){
        AccountService accountService = new AccountService();
        return accountService.addDefaultUser();
    }


}
