import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class FactureDAOModele {
    // Méthode pour créer une nouvelle entrée facture dans la base de données
    public static int creer(FactureBeanModele facture, Connection connexion) throws SQLException {
        String sql = "INSERT INTO facture (date, montant, statut) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int idFacture = -1;
        try {
            preparedStatement = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, (java.sql.Date) facture.getDate());
            preparedStatement.setDouble(2, facture.getMontant());
            preparedStatement.setString(3, facture.getStatut());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idFacture = resultSet.getInt(1);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return idFacture;
    }

    // Méthode pour lire la liste des entrées facture depuis la base de données
    public static List<FactureBeanModele> lireListe(Connection connexion) throws SQLException {
        String sql = "SELECT id, date, montant, statut FROM facture";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<FactureBeanModele> listeFacture = new ArrayList<>();
        try {
            preparedStatement = connexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idFacture = resultSet.getInt("id");
                java.sql.Date date = resultSet.getDate("date");
                double montant = resultSet.getDouble("montant");
                String statut = resultSet.getString("statut");
                FactureBeanModele facture = new FactureBeanModele(idFacture, date, montant, statut);
                listeFacture.add(facture);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return listeFacture;
    }
}
