<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Creation d'une commande</title>
        <link rel="stylesheet" href="style/style.css">
    </head>

    <body>

        <header>
            <h1>Informatika</h1>
            <h2>Euskal Herriko Informatic Company</h2>
            <h3>Logiciel de gestion des factures clients</h3>
        </header>

        <section>
            <div class="sectionHeader">
                <h4>Creation d'une commande</h4>
                <button onclick="window.location.href='connexionVue.jsp';" class="deconnexionButton ">Deconnexion</button>
            </div>
            <article class="commandeArticle">
                <div class="ArticleHeader">
                    <div class="clientDiv">
                        <h5>Commande :</h5>

                        <label for="client-select">Designation client :</label>
                        <select name="clients" id="client-select">
                        <option value="">--Please choose an option--</option>
                        <option value="client1">client 1</option>
                        <option value="client2">client 2</option>
                        <option value="client3">client 3</option>
                        <option value="client4">client 4</option>
                    </select>
                        <label for="n-client-select">Numero client :</label>
                        <input type="text" id="n-client-select">
                    </div>
                    <div class="ProduitDiv">
                        <h5>Produit :</h5>

                        <label for="produit-select">Produit :</label>
                        <select name="produits" id="produit-select">
                            <option value="">--Please choose an option--</option>
                            <option value="client1">produit 1</option>
                            <option value="client2">produit 2</option>
                            <option value="client3">produit 3</option>
                            <option value="client4">produit 4</option>
                        </select>
                        <label for="qte-select">Quantite :</label>
                        <input type="text" id="qte-select">
                        <button class="ajouterButton">Ajouter</button>
                    </div>
                </div>
                <div class="TableauProduit">
                    <table>
                        <thead>
                            <tr>
                                <th>Ref</th>
                                <th>Produit</th>
                                <th>Prix unitaire</th>
                                <th>Client</th>
                                <th>Quantite</th>
                                <th>Prix total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- A chaque fois, il faut ajouter une balise <tr> comme ci dessous avec des balises <td> qui 
                                integrent le contenu des tables de la BDD -->
                            <tr>
                                <td>1</td>
                                <td>Produit 1</td>
                                <td>10</td>
                                <td>Client A</td>
                                <td>2</td>
                                <td>20</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                <div class="articleFooter">

                </div>
            </article>
        </section>
    </body>

    </html>