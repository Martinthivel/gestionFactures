import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDDModele {
    private Connection connexion; // Objet de connexion � la base de donn�es

    public ConnexionBDDModele() {
        // Constructeur par d�faut
        try {
            // Charger le pilote JDBC MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // Etablir la connexion � la base de donn�es
            String url = "jdbc:mysql://localhost:3306/gestionfactures"; // Remplacer "ma_base_de_donnees" par le nom de votre base de donn�es
            String utilisateur = "root"; // Remplacer "nom_utilisateur" par le nom d'utilisateur de votre base de donn�es
            String motDePasse = ""; // Remplacer "mot_de_passe" par le mot de passe de votre base de donn�es
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void fermerConnexion() {
        try {
            if (connexion != null && !connexion.isClosed()) {
                connexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}