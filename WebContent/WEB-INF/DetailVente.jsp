<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-ENCHERES/DetailVente</title>
</head>
<body>
<form method="post" action="VenteServlet">
		<p style="color: black">ENI-ENCHERES :</p>
		<h2>Détail vente</h2>
		 <p>Article : 
        	<%String nom = (String) request.getAttribute("nom");
        	out.println( nom );
        	 %>
        </p>
		<p>Description : 
        	<%String description = (String) request.getAttribute("description");
        	out.println( description );
        	 %>
        </p>        
		<p>Catégorie : 
        	<%String categorie = (String) request.getAttribute("categorie");
        	out.println( categorie );
        	 %>
        </p> 
		<p>Meilleur offre : 
        	<%String prixVente = (String) request.getAttribute("prixVente");
        	out.println( prixVente );
        	 %>
        </p>   
		<p>Mise à prix : 
        	<%String prixInit = (String) request.getAttribute("prixInit");
        	out.println( prixInit );
        	 %>
        </p>  
		<p>Fin de l'enchère : 
        	<%String dateFin = (String) request.getAttribute("dateFin");
        	out.println( dateFin );
        	 %>
        </p>    
		<p>Retrait : 
        	<%String rue = (String) request.getAttribute("rue");
        	out.println( rue );
        	 %>
        	 <%String cp = (String) request.getAttribute("cp");
        	out.println( cp );
        	 %>
        	 <%String ville = (String) request.getAttribute("ville");
        	out.println( ville );
        	 %>
        </p>
		<p>Vendeur : 
        	<%String vendeur = (String) request.getAttribute("vendeur");
        	out.println( vendeur );
        	 %>
        </p> 
        Ma proposition : <input type="number" value="Encherir" style="text-align: center">

		<input type="submit" value="Encherir" style="text-align: center">
		
</body>
</html>