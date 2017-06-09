package login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //PrintWriter out = response.getWriter();

        String n=request.getParameter("emailadres");
        String p=request.getParameter("password");



        LoginValidate controleLogin = new LoginValidate();

        // Valaditioin email
        boolean statusControleEmailAdres = controleLogin.usernameValadionCorrectEmailAdres(n);
        //boolean statusLogin = false;
        boolean statusLogin = controleLogin.loginValidate(n);

        if(statusLogin == true & statusControleEmailAdres == true){
            // Dispatch to welcome screen
            System.out.println("Login succesvol login.java go to loginsuccesvol.html");
            RequestDispatcher rd=request.getRequestDispatcher("loginsuccesvol.html");
            rd.forward(request,response);
        }else{
            // Dispatch to error screen, not welcoma
            System.out.println("Login NOT succesvol login.java go to loginerror.html");
            RequestDispatcher rd=request.getRequestDispatcher("loginerror.html");
            rd.forward(request,response);
        }
    }
}