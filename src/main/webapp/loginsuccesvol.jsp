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

out.print("<form action='GetUser' method='POST'> "
+ "Enter emailadres : <input type='text' name='emailadres' value='" + emailadres + "'>"
+ "<input type='submit' ></form>");
out.print("<br>");

out.print("Jou gegevens wijzingen:");
out.print("<form name='ShowEditUserCredentials' action='ShowEditUserCredentials' method='POST'> "
+ "<input type='hidden' name='emailadres' value='" + emailadres + "'>"
+ "<A href='javascript:document.ShowEditUserCredentials.submit()'>Wijzig gegevens</A>"
+ "</form>");

out.print("<br>");
session.setAttribute("emailadres",emailadres);
out.print("<br>" + "Wil je het account verwijderen klik hier onder: " + "<br>");
out.print("<a href='customer/verwijderaccount.html'>Verwijder account</a><br><br>");

%>
</body>
</html>