import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOModele {
    private Connection connexion;

    // Constructeur pour �tablir la connexion � la base de donn�es
    public ProduitDAOModele(Connection connexion) {
        this.connexion = connexion;
    }

    // M�thode pour cr�er un nouveau produit dans la base de donn�es
    public int creer(ProduitBeanModele produit) throws SQLException {
        int resultat = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String requete = "INSERT INTO produit (designation, ref, prix) VALUES (?, ?, ?)";

        try {
            preparedStatement = connexion.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, produit.getDesignation());
            preparedStatement.setString(2, produit.getRef());
            preparedStatement.setDouble(3, produit.getPrix());
            resultat = preparedStatement.executeUpdate();

            // R�cup�rer l'ID g�n�r� pour le nouveau produit
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                produit.setId(resultSet.getInt(1));
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

    // M�thode pour lire la liste des produits depuis la base de donn�es
    public List<ProduitBeanModele> lireListe() throws SQLException {
        List<ProduitBeanModele> listeProduits = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String requete = "SELECT id, designation, ref, prix FROM produit";

        try {
            preparedStatement = connexion.prepareStatement(requete);
            resultSet = preparedStatement.executeQuery();

            // Parcourir les r�sultats de la requ�te et cr�er des objets ProduitBeanModele
            while (resultSet.next()) {
                ProduitBeanModele produit = new ProduitBeanModele();
                produit.setId(resultSet.getInt("id"));
                produit.setDesignation(resultSet.getString("designation"));
                produit.setRef(resultSet.getString("ref"));
                produit.setPrix(resultSet.getDouble("prix"));
                listeProduits.add(produit);
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

        return listeProduits;
    }
}
