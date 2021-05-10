<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="VenteServlet">
		<p style="color: black">ENI-ENCHERES :</p>
		<h2><center>Nouvelle vente</center></h2>
		Article : <input type="text" name="article" value="${article}"><br />
		Description : <input type="text" name="description" value="${description}"><br />
		Catégorie :<select name="categorie" value="${catégorie}"></select>
		Mise à prix : <input type="number" name="prix" value="${prix }"><br />
		Début de l'enchère : <input type="datetime" name="debutEnchere" value="${debutEnchere }"><br />
		Fin de l'enchère : <input type="datetime" name="finEnchere" value="${finEnchere }"><br />
		
		<input type="submit" value="Enregistrer">
		<input type="submit" value="Annuler">
		
</body>
</html>