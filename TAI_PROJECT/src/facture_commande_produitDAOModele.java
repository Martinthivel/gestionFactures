import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class facture_commande_produitDAOModele {
    // Méthode pour créer une nouvelle entrée facture_commande_produit dans la base de données
    public static int creer(facture_commande_produitBeanModele factureCommandeProduit, Connection connexion) throws SQLException {
        String sql = "INSERT INTO facture_commande_produit (id_facture, id_commande_produit) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int idFactureCommandeProduit = -1;
        try {
            preparedStatement = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, factureCommandeProduit.getIdFacture());
            preparedStatement.setInt(2, factureCommandeProduit.getIdCommandeProduit());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idFactureCommandeProduit = resultSet.getInt(1);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return idFactureCommandeProduit;
    }

    // Méthode pour lire la liste des entrées facture_commande_produit depuis la base de données
    public static List<facture_commande_produitBeanModele> lireListe(Connection connexion) throws SQLException {
        String sql = "SELECT id_facture, id_commande_produit FROM facture_commande_produit";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<facture_commande_produitBeanModele> listeFactureCommandeProduit = new ArrayList<>();
        try {
            preparedStatement = connexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idFacture = resultSet.getInt("id_facture");
                int idCommandeProduit = resultSet.getInt("id_commande_produit");
                facture_commande_produitBeanModele factureCommandeProduit = new facture_commande_produitBeanModele(idFacture, idCommandeProduit);
                listeFactureCommandeProduit.add(factureCommandeProduit);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return listeFactureCommandeProduit;
    }
}