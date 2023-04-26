import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeDAOModele {
    // Méthode pour créer une nouvelle commande dans la base de données
    public static int creer(CommandeBeanModele commande, Connection connexion) throws SQLException {
        String sql = "INSERT INTO commande (id_client, montant, date_commande) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int idCommande = -1;
        try {
            preparedStatement = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, commande.getId_client());
            preparedStatement.setDouble(2, commande.getMontant());
            preparedStatement.setDate(3, (java.sql.Date) commande.getDate_commande());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idCommande = resultSet.getInt(1);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return idCommande;
    }

    // Méthode pour lire la liste des commandes depuis la base de données
    public static List<CommandeBeanModele> lireListe(Connection connexion) throws SQLException {
        String sql = "SELECT id, id_client, montant, date_commande FROM commande";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CommandeBeanModele> listeCommandes = new ArrayList<>();
        try {
            preparedStatement = connexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCommande = resultSet.getInt("id");
                int idClient = resultSet.getInt("id_client");
                double montant = resultSet.getDouble("montant");
                Date dateCommande = resultSet.getDate("date_commande");
                CommandeBeanModele commande = new CommandeBeanModele(idCommande, idClient, montant, dateCommande);
                listeCommandes.add(commande);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return listeCommandes;
    }
}
