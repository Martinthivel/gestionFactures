<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Service Financese</title>
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
                <h4>Service Finances</h4>
                <button onclick="window.location.href='connexionVue.jsp';" class="deconnexionButton ">Deconnexion</button>
            </div>
            <article class="financeArticle">
                <div class="ArticleHeader">
                    <div class="clientDiv">
                        <label for="client-select">Client :</label>
                        <select name="clients" id="client-select">
                        <option value="">--Please choose an option--</option>
                        <option value="client1">client 1</option>
                        <option value="client2">client 2</option>
                        <option value="client3">client 3</option>
                        <option value="client4">client 4</option>
                    </select>
                        <label for="n-client-select">Numero client :</label>
                        <input type="text" id="n-client-select">
                        <button id="searchButton">Rechercher</button>
                    </div>

                </div>
                <h2>Il-y-a X factures a valider pour ce client</h2>

                <div class="TableauFacture">
                    <table>
                        <thead>
                            <tr>
                                <th>Numero</th>
                                <th>Client</th>
                                <th>Montant Total</th>
                                <th>Etat</th>
                                <th>Validation</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- A chaque fois, il faut ajouter une balise <tr> comme ci dessous avec des balises <td> qui 
                                integrent le contenu des tables de la BDD -->
                            <tr>
                                <td>16556</td>
                                <td>ESTIA</td>
                                <td>7855</td>
                                <td>A valider</td>
                                <td>
                                    <Button id="voirFactureButton">Voir</Button>
                                    <button id="validerFactureButton">Valider</button>
                                </td>
                            </tr>
                            <tr>
                                <td>55489</td>
                                <td>Bidart</td>
                                <td>75419</td>
                                <td>Payee</td>
                                <td>
                                    <Button id="voirFactureButton">Voir</Button>
                                </td>
                            </tr>
                            <tr>
                                <td>74521</td>
                                <td>Mousques</td>
                                <td>447785</td>
                                <td>Non payee</td>
                                <td>
                                    <Button id="voirFactureButton">Voir</Button>
                                    <button id="relanceFactureButton">Relance</button>
                                </td>
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