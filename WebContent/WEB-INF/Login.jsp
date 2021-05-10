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
<form method="post" action="LoginServlet">
<p style="color:black"> ENI-ENCHERES :</p>
	<h1><center>Identifiant : <input type="text" name="login"></center></h1><br/>
	<center>Mot de passe : <input type="password" name="pass"></center><<br />
	<center><input type="submit" value="Se connecter.." style="width:130px"></center><br/>
</form>
<form method ="post" action="MonInscriptionServlet">
	<center><input type="submit" value="Créer un compte" style="width:200px"></center><br/>
</form>	
</body>
</html>



