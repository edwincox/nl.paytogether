package account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetAccount extends HttpServlet {

    public AccountCredentials accountCredentials;

    // HttpServletRequest to read the HTTP header infromation.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // titel
        String title = "Edwin's first get methode";

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";

        // Nodige voor verficatie om welke user het gaat
        String emailtijdelijk = request.getParameter("emailadres");

        // Gevens ophalen door emaladres
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials object = makeuser.getAccountForUser(emailtijdelijk);

        // http://192.168.0.71:8181/naamartifactId-1.0-SNAPSHOT/GetAccount?emailadres=edje_coxje%40hotmail.com
        //String parm1 = object.getAchternaam();

        out.println(docType
                + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "GET Hier onder worden de gegevens weergeven: <br>"
                + "<br> Voornaam: " + object.getVoornaam()
                + "<br> Achternaam: " +object.getAchternaam()
                + "<br> Straatnaam: " + object.getStraatnaam()
                + "<br> huisnummer: " + object.getHuisnummer()
                + "<br> postcode: " + object.getPostcode()
                + "<br> passwoord: " + object.getPassword()
                + "<br> emailadres: " + object.getEmailadres()
                + "</body></html>");
    }
}