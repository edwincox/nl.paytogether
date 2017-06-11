package account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteUser extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get nummer welk nummer is er opgeven in het form
        String emailadres = request.getParameter("emailadres");

        // Maak een person aan
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials person = makeuser.getAccountForUser(emailadres);

        boolean isAccountJuistVerwijderd = makeuser.deleteAccountForUser(emailadres);

        if(isAccountJuistVerwijderd){

            PrintWriter out = response.getWriter();
            String title = "Account verwijderd";

            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";

            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Jou account is verwijderd, het account bestaat niet meer"
                    + "Wat is de waarde 1" + isAccountJuistVerwijderd
                    + "</h2>\n" +
                    "</body></html>");

        }else{

            PrintWriter out = response.getWriter();
            String title = "ERROR bij account verwijderd";

            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";

            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Account bestaat ! <br> of het account is al verwijderd !"
                    + "Wat is de waarde 2" + isAccountJuistVerwijderd
                    + "</h2>\n" +
                    "</body></html>");
        }
    }
}