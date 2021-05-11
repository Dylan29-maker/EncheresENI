<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES/Vente</title>
</head>
<body>
	<form method="post" action="VenteServlet">
		<p style="color: black">ENI-ENCHERES :</p>
		<center>
		<h2>Nouvelle vente</h2>
		Utilisateur : <SELECT name="utilisateurs">
			<c:forEach items="${model.listeUtilisateur}" var="utilisateur">
				<OPTION value="${utilisateur.no_utilisateur }">
					${utilisateur.pseudo}</OPTION>
			</c:forEach>
		</SELECT><br><br>
		Article : <input type="text" name="article" value="${article}"><br><br>
		Description : <input type="text" name="description" value="${description}"><br><br>
		Catégories : <SELECT name="categories">
			<c:forEach items="${model.listeCategories}" var="categorie">
				<OPTION value="${categorie.no_categorie }">
					${categorie.libelle}</OPTION>
			</c:forEach>
		</SELECT><br><br>
		Mise à prix : <input type="number" name="prix" value="${prix }"><br><br>
		Début de l'enchère : <input type="date" name="debutEnchere" value="${debutEnchere }"><br><br>
		Fin de l'enchère : <input type="date" name="finEnchere" value="${finEnchere }"><br><br>
		
		<p>Retraits :</p>
		Rue : <input type="text" name="rue" value="${rue}"><br><br>
		Code Postal : <input type="text" name="cp" value="${cp}"><br><br>
		Ville : <input type="text" name="ville" value="${ville}"><br><br>
		
		<input type="submit" value="Enregistrer"> ${model.result }
		<a href="<%=request.getContextPath()+"/AccueilServlet"%>">
		<p style="color: blue;">Annuler</p>
		</a>
		</center>
</body>
</html>