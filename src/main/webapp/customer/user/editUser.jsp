<html>
<body>
<%

String voornaam=(String)session.getAttribute("voornaam");
String achternaam=(String)session.getAttribute("achternaam");
String straatnaam=(String)session.getAttribute("straatnaam");
String huisnummer=(String)session.getAttribute("huisnummer");
String postcode=(String)session.getAttribute("postcode");

String emailadres=request.getParameter("emailadres");



String foutgegaan=request.getParameter("fout");

out.print("Hier kun je gegevens wijzgen " + voornaam + "<br><br>");
out.print("<b>Je gegevens zijn:</b>");

out.print("<form action='EditUser' method='POST'> "
+ "voornaam: <input type='text' name='voornaam' value='" + voornaam + "'>"
+ "<br> achternaam: <input type='text' name='achternaam' value='" + achternaam + "'>"
+ "<br> straatnaam: <input type='text' name='straatnaam' value='" + straatnaam + "'>"
+ "<br> huisnummer: <input type='text' name='huisnummer' value='" + huisnummer + "'>"
+ "<br> postcode: <input type='text' name='postcode' value='" + postcode + "'>"
+ "<br> emailadres: <input type='text' name='emailadres' value='" + emailadres + "'>"
+ "<br> <input type='submit' ></form>");
out.print("<br>");

%>
</body>
</html>