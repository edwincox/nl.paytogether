<html>
<body>
<%

String voornaam=(String)session.getAttribute("voornaam");
String achternaam=(String)session.getAttribute("achternaam");
String emailadres=request.getParameter("emailadres");



out.print("Welcome je bent succesvol ingelogd met emailadres:     " + emailadres + "<br><br>");
out.print("<br>");
out.print("<b>Je gegevens zijn:</b>");
out.print("<br>");
out.print("Voornaam: " + voornaam + "<br>");
out.print("Achternaam: " + achternaam + "<br>");
out.print("<br>");
out.print("<br>");
out.print("Om je gegevens op te vragen klik hier: <br>");

out.print("<a href='account/gegevensophalen.jsp'>Gegevens ophalen</a><br><br>");

out.print("<form action='GetUser' method='POST'> "
+ "Enter emailadres : <input type='text' name='emailadres' value='" + emailadres + "'>"
+ "<input type='submit' ></form>");


session.setAttribute("emailadres",emailadres);
out.print("<br>" + "Wil je het account verwijderen klik hier onder: " + "<br>");
out.print("<a href='account/verwijderaccount.html'>Verwijder account</a><br><br>");



%>
</body>
</html>