<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES</title>
</head>
<body>
<form action="MonInscriptionServlet" method="POST">
	<h1>Mon Profil</h1>
	<center>pseudo : <input type="text" name="Pseudo" value="${pseudo}"required> Nom : <input type="text" name="nom" value="${nom}"required></center> <br />
	<center>prenom : <input type="text" name="Prenom" value="${prenom}"required> Email : <input type="text" name="email" value="${email}"required></center> <br />
	<center>telephone : <input type="text" name="NumTel" value="${telephone}"required> Rue : <input type="text" name="rue" value="${rue}"required></center> <br />
	<center>code_postal : <input type="text" name="CodePostal" value="${code_postal}"required> ville : <input type="text" name="Ville" value="${ville}"required></center><br />
	<center>mot_de_passe : <input type="text" name="mot_de_passe" value="${mot_de_passe}"required> confirmationMDP : <input type="text" name="confirmationMDP" value="${confirmationMDP}"required></center><br />
</form>

<form action="MonProfil" method="POST"> 
	<center> <input type="submit" value="Créer un compte" style="width:200px"></center><br/>
</form>

<form action="LoginServlet" method ="POST">
	<center> <input type="submit" value="Annuler" style="width:200px"></center><br/>
</form>

</body>
</html>