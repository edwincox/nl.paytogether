package account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetAantal extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get nummer welk nummer is er opgeven in het form
        //String number = request.getParameter("number");

        // Maak een person aan
        //PayToGetherApplication makeuser = new PayToGetherApplication();

        //AccountCredentials person = makeuser.getAccountForUser(emailadres);

        PayToGetherApplication makeuser = new PayToGetherApplication();
        int aantalterug = makeuser.getAantalAccount();



            PrintWriter out = response.getWriter();

            // Get nummer wat wordt opgeven in het form
            //number = Integer.parseInt(request.getParameter("number"));

            String title = "Aantal repository in list";

            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<h2 align=\"center\"> "
                    + "Aantal aacount in List: " + aantalterug + "<br><br>"
                    + "</h2>\n" +
                    "</body></html>");
    }
}
