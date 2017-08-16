package account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EditUser extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // titel
        String title = "editUser account";

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";

        String voornaam = request.getParameter("voornaam");
        String achternaam = request.getParameter("achternaam");
        String straatnaam = request.getParameter("straatnaam");
        String huisnummer = request.getParameter("huisnummer");
        String postcode = request.getParameter("postcode");
        String emailadres = request.getParameter("emailadres");

        PayToGetherApplication makeNewUser = new PayToGetherApplication();
        AccountCredentials accountCredentials = makeNewUser.editAccountForUser(voornaam, achternaam, straatnaam, huisnummer, postcode, emailadres);

        if(accountCredentials != null){

            out.println(docType
                    + "<html>\n"
                    + "<head><title>" + title + "</title></head>\n"
                    + "<body bgcolor=\"#f0f0f0\">\n"
                    + "Het aanmelden is gelukt, u kunt nu inloggen ga naar het begin pagina"
                    + "<u><b><a href='index.html'>go to index</a></b></u>"
                    + "Hier onder worden de gegevens weergeven: <br>"
                    + "<br>  Voornaam: " + request.getParameter("voornaam")
                    + "<br> Achternaam: " + request.getParameter("achternaam")
                    + "<br> Straatnaam: " + request.getParameter("straatnaam")
                    + "<br> huisnummer: " + request.getParameter("huisnummer")
                    + "<br> postcode: " + request.getParameter("postcode")
                    + "<br> password: " + request.getParameter("password")
                    + "<br> emailadres: " + request.getParameter("emailadres")
                    + "</body></html>");
        }else{
            // Dispatch to error screen, not welcoma
            System.out.println("Login NOT succesvol login.java go to loginerror.html");
            RequestDispatcher rd=request.getRequestDispatcher("loginsuccesvol.jsp");
            String foutgegaanbijophalen = "ERROR 345";

            // setAttribute voor request
            HttpSession session = request.getSession();
            session.setAttribute("fout", foutgegaanbijophalen);

            rd.forward(request,response);
        }
    }
}