import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOModele {
    private Connection connexion;

    // Constructeur pour établir la connexion à la base de données
    public ClientDAOModele(Connection connexion) {
        this.connexion = connexion;
    }

    // Méthode pour créer un nouveau client dans la base de données
    public int creer(ClientBeanModele client) throws SQLException {
        int resultat = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String requete = "INSERT INTO clients (nom, adresse_numero, adresse_voie, adresse_cp, adresse_ville, email, tel, identifiant_connexion, mdp, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connexion.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getAdresse_num());
            preparedStatement.setString(3, client.getAdresse_voie());
            preparedStatement.setString(4, client.getAdresse_cp());
            preparedStatement.setString(5, client.getAdresse_ville());
            preparedStatement.setString(6, client.getEmail());
            preparedStatement.setString(7, client.getTel());
            resultat = preparedStatement.executeUpdate();

            // Récupérer l'ID généré pour le nouveau client
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                client.setId(resultSet.getInt(1));
            }
        } finally {
            // Fermer les ressources
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return resultat;
    }

    // Méthode pour lire la liste des clients depuis la base de données
    public List<ClientBeanModele> lireListe() throws SQLException {
        List<ClientBeanModele> listeClients = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String requete = "SELECT id, nom, adresse_numero, adresse_voie, adresse_cp, adresse_ville, email, tel FROM clients";

        try {
            preparedStatement = connexion.prepareStatement(requete);
            resultSet = preparedStatement.executeQuery();

            // Parcourir les résultats de la requête et créer des objets ClientsBeanModele
            while (resultSet.next()) {
                ClientBeanModele client = new ClientBeanModele();
                client.setId(resultSet.getInt("id"));
                client.setNom(resultSet.getString("nom"));
                client.setAdresse_num(resultSet.getString("adresse_numero"));
                client.setAdresse_voie(resultSet.getString("adresse_voie"));
                client.setAdresse_cp(resultSet.getString("adresse_cp"));
                client.setAdresse_ville(resultSet.getString("adresse_ville"));
                client.setEmail(resultSet.getString("email"));
                client.setTel(resultSet.getString("tel"));
                listeClients.add(client);
            }
        } finally {
            // Fermer les ressources
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return listeClients;
    }
}
