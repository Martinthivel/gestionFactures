import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAOModele {
    // Méthode pour créer une nouvelle entrée employe dans la base de données
    public static int creer(EmployeBeanModele employe, Connection connexion) throws SQLException {
        String sql = "INSERT INTO employe (nom, prenom, identifiant_connexion, mdp, role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int idEmploye = -1;
        try {
            preparedStatement = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employe.getNom());
            preparedStatement.setString(2, employe.getPrenom());
            preparedStatement.setString(3, employe.getIdentifiantConnexion());
            preparedStatement.setString(4, employe.getMdp());
            preparedStatement.setString(5, employe.getRole());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idEmploye = resultSet.getInt(1);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return idEmploye;
    }

    // Méthode pour lire la liste des entrées employe depuis la base de données
    public static List<EmployeBeanModele> lireListe(Connection connexion) throws SQLException {
        String sql = "SELECT id, nom, prenom, identifiant_connexion, mdp, role FROM employe";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EmployeBeanModele> listeEmploye = new ArrayList<>();
        try {
            preparedStatement = connexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idEmploye = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String identifiantConnexion = resultSet.getString("identifiant_connexion");
                String mdp = resultSet.getString("mdp");
                String role = resultSet.getString("role");
                EmployeBeanModele employe = new EmployeBeanModele(idEmploye, nom, prenom, identifiantConnexion, mdp, role);
                listeEmploye.add(employe);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return listeEmploye;
    }
}
