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

        // Gevens ophalen door emaladres
        PayToGetherApplication makeuser = new PayToGetherApplication();
        String emailtijdelijk = request.getParameter("emailadres");
        AccountCredentials object = makeuser.getAccountForUser(emailtijdelijk);


        String parm1 = object.getAchternaam();
//        PayToGetherApplication makeuser = new PayToGetherApplication();
//        AccountCredentials objectbinnen = makeuser.getAccountForUser(request.getParameter("emailadres"));



        out.println(docType
                + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "Hier onder worden de gegevens weergeven: <br>"
                + "<br> Voornaam: " + request.getParameter("voornaam")
                + "<br> Achternaam: " +request.getParameter("achternaam")
                + "<br> Straatnaam: " + request.getParameter("straatnaam")
                + "<br> huisnummer: " + request.getParameter("huisnummer")
                + "<br> postcode: " + request.getParameter("postcode")
                + "<br> username: " + request.getParameter("username")
                + "<br> passwoord: " + request.getParameter("passwoord")
                + "<br> emailadres: " + request.getParameter("emailadres")
                + "<br> emailadres 2: " + parm1
                + "<br> emailadres 3: " + object.getAchternaam()
                + "</body></html>");
    }
}