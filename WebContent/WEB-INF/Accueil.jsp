<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES</title>
</head>
<body>
	<form method="post" action="AccueilServlet">
		<p style="color: black">ENI-ENCHERES :</p>
		<div style="text-align: right">
			<p style="color: blue;">Encheres</p>
			<p style="color: blue;">Vendre un article</p>
			<p style="color: blue;">Profil</p>
		</div>
		<h2>
			<center>Liste des encheres</center>
		</h2>
		<p style="color: black">Filtres :</p>
		<input type="search" name="nom" value="${nom}"><br />
		<br /> Catégories : <SELECT name="categories">
			<option value="0">Toutes</option>
			<c:forEach items="${model.listeCategories}" var="categorie">
				<OPTION value="${categorie.no_categorie }">
					${categorie.libelle}</OPTION>

			</c:forEach>
		</SELECT><br /> 
		<div class = "achat">
			<input type="radio" id="choixAchat" name="choix" value="Achat">
			<label for="choixAchat">Achats</label>
			<div>
			<input type="checkbox" id="eo" name="choixAchat" value="eo"> <label
				for="eo">Enchères ouvertes</label>
			</div>
			<div>
			<input type="checkbox" id="me" name="choixAchat" value="me"> <label
				for="me">Mes enchères</label>
			</div>
			<div>
			<input type="checkbox" id="mer" name="choixAchat" value="mer"> <label
				for="mer">Mes enchères remportées</label>
			</div>
		</div>
		<div class = "vente">
			<input type="radio" id="choixVente" name="choix" value="Ventes">
			<label for="choixAchat">Ventes</label>
			<div>
			<input type="checkbox" id="mvc" name="choixVente" value="mvc"> <label
				for="mvc">Mes ventes en cours</label>
			</div>
			<div>
			<input type="checkbox" id="vnd" name="choixVente" value="vnd"> <label
				for="vnd">Ventes non débutés</label>
			</div>
			<div>
			<input type="checkbox" id="vt" name="choixVente" value="vt"> <label
				for="vt">Ventes terminés</label>
			</div>
		</div>
		<center>
			<input type="submit" value="Rechercher" style="text-align: center">
		</center>
		<br />
		<br />

		<c:forEach items="${model.listeArticles}" var="article">
			<p>${article.description }</p>
			<p>Prix : ${article.prix_initial }</p>
			<p>Fin de l'enchere : ${article.date_fin_encheres }</p>
			<p>Vendeur : ${article.utilisateur.nom }</p>
			<p>-------------------------------------------</p>
		</c:forEach>
	</form>
</body>
</html>