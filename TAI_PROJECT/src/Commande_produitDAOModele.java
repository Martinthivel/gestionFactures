import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Commande_produitDAOModele {
    // Méthode pour créer une nouvelle entrée commande_produit dans la base de données
    public static int creer(Commande_produitBeanModele commandeProduit, Connection connexion) throws SQLException {
        String sql = "INSERT INTO commande_produit (id_commande, id_produit, quantite) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int idCommandeProduit = -1;
        try {
            preparedStatement = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, commandeProduit.getIdCommande());
            preparedStatement.setInt(2, commandeProduit.getIdProduit());
            preparedStatement.setInt(3, commandeProduit.getQuantite());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idCommandeProduit = resultSet.getInt(1);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return idCommandeProduit;
    }

    // Méthode pour lire la liste des entrées commande_produit depuis la base de données
    public static List<Commande_produitBeanModele> lireListe(Connection connexion) throws SQLException {
        String sql = "SELECT id, id_commande, id_produit, quantite FROM commande_produit";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Commande_produitBeanModele> listeCommandeProduit = new ArrayList<>();
        try {
            preparedStatement = connexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCommandeProduit = resultSet.getInt("id");
                int idCommande = resultSet.getInt("id_commande");
                int idProduit = resultSet.getInt("id_produit");
                int quantite = resultSet.getInt("quantite");
                Commande_produitBeanModele commandeProduit = new Commande_produitBeanModele(idCommandeProduit, idCommande, idProduit, quantite);
                listeCommandeProduit.add(commandeProduit);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return listeCommandeProduit;
    }
}
