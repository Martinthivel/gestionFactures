<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tous les produits</title>
</head>
<body>
	<ul>
		<c:forEach items="${produitListe}" var="produit">
			<li><c:out value="${produit.nom}" /></li>
		</c:forEach>
	</ul>
	<table>
		<tr>
			<th>Nom</th>
			<th>Prix</th>
		</tr>
		<c:forEach items="${produitListe}" var="produit">
			<tr>
				<td><c:out value="${produit.nom}" /></td>
				<td><c:out value="${produit.prix}" /></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>

