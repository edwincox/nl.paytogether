package account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetUser extends HttpServlet {

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get nummer welk nummer is er opgeven in het form
        String emailadres = request.getParameter("emailadres");

        // Maak een person aan
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials person = makeuser.getAccountForUser(emailadres);

        if(person != null){

            PrintWriter out = response.getWriter();

            // Get nummer wat wordt opgeven in het form
            //number = Integer.parseInt(request.getParameter("number"));

            String title = "Opgevraagde user heeft de volgende gegevens";

            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Voornaam: " + person.getVoornaam() + "<br><br>"
                    + "Achternaam: " + person.getAchternaam() + "<br><br>"
                    + "Straatnaam: " + person.getStraatnaam() + "<br><br>"
                    + "Huisnummer: " + person.getHuisnummer() + "<br><br>"
                    + "Postcode: " + person.getPostcode() + "<br><br>"
                    + "Username: " + person.getEmailadres() + "<br><br>"
                    + "<button type=\"button\" name=\"back one page\" onclick=\"history.back()\">back</button>"
                    + "</h2>\n" +
                    "</body></html>");
        } else {

            PrintWriter out = response.getWriter();
            //number = Integer.parseInt(request.getParameter("number"));

            String title = "Total Number of Hits";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Bestaat niet deze user<br><br>"
                    + "Object opgehaald: ERROR!!!!! <br><br>"
                    + "</h2>\n" +
                    "</body></html>");
        }
    }


    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get nummer welk nummer is er opgeven in het form
        String emailadres = request.getParameter("emailadres");

        // Maak een person aan
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials person = makeuser.getAccountForUser(emailadres);

        if(person != null){

            PrintWriter out = response.getWriter();

            // Get nummer wat wordt opgeven in het form
            //number = Integer.parseInt(request.getParameter("number"));

            String title = "Opgevraagde user heeft de volgende gegevens";

            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Voornaam: " + person.getVoornaam() + "<br><br>"
                    + "Achternaam: " + person.getAchternaam() + "<br><br>"
                    + "Straatnaam: " + person.getStraatnaam() + "<br><br>"
                    + "Huisnummer: " + person.getHuisnummer() + "<br><br>"
                    + "Postcode: " + person.getPostcode() + "<br><br>"
                    + "Username: " + person.getEmailadres() + "<br><br>"
                    + "</h2>\n" +
                    "</body></html>");
        } else {

            PrintWriter out = response.getWriter();
            //number = Integer.parseInt(request.getParameter("number"));

            String title = "Total Number of Hits";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Bestaat niet deze user<br><br>"
                    + "Object opgehaald: ERROR!!!!! <br><br>"
                    + "</h2>\n" +
                    "</body></html>");
        }
    }
}