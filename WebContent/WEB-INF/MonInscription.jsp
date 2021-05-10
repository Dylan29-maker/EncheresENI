<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES</title>
</head>
<body>
<form action="MonProfilServlet" method="POST">
	<h1>Mon Profil</h1>
	Pseudo : <input type="text" name="nom" value="${pseudo}"required><br />
	Prenom : <input type="text" name="nom" value="${Prenom}"required><br />
	NumTel : <input type="text" name="nom" value="${NumTel}"required><br />
	CodePostal : <input type="text" name="nom" value="${Cod}"required><br />







</body>
</html>