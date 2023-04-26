<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un nouveau produit</title>
</head>
<body>
	<form action="ProduitAjoutControleur" method="post">
		nom : <input type="text" name="nom" /> <br /> 
		prix : <input type="text" name="prix" /> <br /> 
		<a href="ProduitListeControleur"><br /></a><input type="submit" />
	</form>
	<li><a href="accueilVue.jsp">Retour au menu<br /></a></li>
</body>
</html>