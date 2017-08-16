package account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowEditUserCredentials extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get emailadres wat door het forum wordt doorgeven
        String putEmailadres = request.getParameter("emailadres");

        // Account ophalen
        PayToGetherApplication makeuser = new PayToGetherApplication();
        AccountCredentials person = makeuser.getAccountForUser(putEmailadres);

        // setAttribute voor request
        HttpSession session = request.getSession();

        String voornaam = person.getVoornaam();
        session.setAttribute("voornaam", voornaam);

        String getAchternaam = person.getAchternaam();
        session.setAttribute("achternaam", getAchternaam);

        String getEmailAdres = person.getEmailadres();
        session.setAttribute("emailadres", getEmailAdres);

        String getStraatnaam = person.getStraatnaam();
        session.setAttribute("straatnaam", getStraatnaam);
        String getHuisnummer = person.getHuisnummer();
        session.setAttribute("huisnummer", getHuisnummer);
        String getPostcode = person.getPostcode();
        session.setAttribute("postcode", getPostcode);


        // Proberen een object via session te laten gaan
        Object object = person;
        session.setAttribute("object", object);

        System.out.println("TRACE." + putEmailadres);
        System.out.println("TRACE2." + getEmailAdres);

        if (putEmailadres.equals(getEmailAdres)) {
            // Dispatch to welcome screen
            System.out.println("Login succesvol login.java go to editUser.jsp");
            //RequestDispatcher rd=request.getRequestDispatcher("editUser.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("customer/user/editUser.jsp");
            rd.forward(request, response);
        } else {
            // Dispatch to error screen, not welcoma
            System.out.println("Fout met ophalen gegevens!");
            String foutgegaanbijophalen = "Het ophalen van jou gegevens is niet succesvol, probeer het opnieuw";
            session.setAttribute("fout", foutgegaanbijophalen);
            RequestDispatcher rd = request.getRequestDispatcher("loginsuccesvol.jsp");
            rd.forward(request, response);
        }

    }
}