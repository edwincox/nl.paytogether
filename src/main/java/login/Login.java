package login;

import account.AccountCredentials;
import account.PayToGetherApplication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //PrintWriter out = response.getWriter();

        String emailadres=request.getParameter("emailadres");
        String p=request.getParameter("password");

        LoginValidate controleLogin = new LoginValidate();

        // Valaditioin email
        boolean statusControleEmailAdres = controleLogin.usernameValadionCorrectEmailAdres(emailadres);
        //boolean statusLogin = false;
        boolean statusLogin = controleLogin.loginValidate(emailadres);

        // Account ophalen
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials person = makeuser.getAccountForUser(emailadres);

        // setAttribute voor request
        HttpSession session=request.getSession();
        String voornaam = person.getVoornaam();
        session.setAttribute("voornaam",voornaam);
        String achternaam = person.getAchternaam();
        session.setAttribute("achternaam",achternaam);

        // Proberen een object via session te laten gaan
        Object object = person;
        session.setAttribute("object",object);



        if(statusLogin == true & statusControleEmailAdres == true){
            // Dispatch to welcome screen
            System.out.println("Login succesvol login.java go to loginsuccesvol.html");
            //RequestDispatcher rd=request.getRequestDispatcher("loginsuccesvol.html");
            RequestDispatcher rd=request.getRequestDispatcher("loginsuccesvol.jsp");
            rd.forward(request,response);
        }else{
            // Dispatch to error screen, not welcoma
            System.out.println("Login NOT succesvol login.java go to loginerror.html");
            RequestDispatcher rd=request.getRequestDispatcher("loginerror.html");
            rd.forward(request,response);
        }
    }
}