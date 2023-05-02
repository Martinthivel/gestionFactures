<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Gestion des factures</title>
            <link rel="stylesheet" href="style/style.css">
        </head>

        <body>
            <header>
                <h1>Informatika</h1>
                <h2>Euskal Herriko Informatic Company</h2>
                <h3>Logiciel de gestion des factures clients</h3>
            </header>

            <form id="connexionForm" action="ProduitAjoutControleur" method="post">
                <h2>Identification</h2>
                <label for="username">Nom d'utilisateur :</label>
                <input type="text" name="Username" /> <br />
                <label for="password">Mot de passe :</label>
                <input type="text" name="password" /> <br />
                <input type="submit" value="Se connecter">
            </form>

            <a href="commandeVue.jsp">test</a>

        </body>

        </html>