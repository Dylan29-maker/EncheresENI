<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES</title>
</head>
<body>
	<form method="post" action="AccueilServlet">
		<p style="color: black">ENI-ENCHERES :</p>
		<h2>
			<center>Liste des encheres</center>
		</h2>
		<p style="color: black">Filtres : :</p>
		<input type="search" name="nom" value="${nom}"><br /> <SELECT
			name="Categories" size="1">
			<%-- <%
			/* final Iterator lIterator = z.iterator();
			while(lIterator.hasNext()){
			        Categories c=(Categories)lIterator.next(); */
			%>
			<OPTION value="<%=c.getNo_categorie()%>"><%=c.getLibelle()%></OPTION>
			<%
				}
			%> --%>
		</SELECT> <input type="submit" value="Rechercher">
	</form>
</body>
</html>