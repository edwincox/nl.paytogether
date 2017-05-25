package authenticator;

import account.AccountAlreadyExistException;
import account.AccountCredentials;
import account.PayToGetherApplication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String emailadres = request.getParameter("emailadres");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        if(emailadres == null ||password == null ){
            try {
                throw new AccountAlreadyExistException(emailadres);
            } catch (AccountAlreadyExistException e) {
                e.printStackTrace();
            }
        }

        // Class om controle uit te voeren
        Audit authenticator = new Audit();
        String result = authenticator.authenticate(emailadres, password);


        if (result.equals("success")) {
            rd = request.getRequestDispatcher("/success.html");

            // succesvol get account gegevens
            PayToGetherApplication makeuser = new PayToGetherApplication();
            AccountCredentials object = makeuser.getAccountForUser(emailadres);


            request.setAttribute("object", object);

        } else {
            rd = request.getRequestDispatcher("/error.html");
        }
        rd.forward(request, response);
    }

}