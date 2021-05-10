<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES</title>
</head>
<body>
<p style="color:red">${erreur}</p>
<form 
	action="ListeDesEncheresServlet" method = "POST">
</form>
<h1>
Liste Des Enchères :
</h1>
<br>
<label for="Filtre">Filtres:</label>
<input type="search" id="Filtre" name="Filtre_search"
       aria-label="Search through site content">
<button>Search</button>
</br>
CATEGORIES :
<select name = "categories" multiple = "multiple">
	<option value ="1">Informatique</option>
	<option value ="2">Ameublement</option>
	<option value ="3">Vêtements</option>
	<option value ="4">Sports_Loisirs</option>
</select>
</body>
</html>