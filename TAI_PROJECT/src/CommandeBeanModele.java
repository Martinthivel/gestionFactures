import java.util.Date;

public class CommandesBeanModele {
    private int id;
    private int id_client;
    private String clients;
    private double montant;
    private Date date_commande;

    // Constructeur(s)
    // Getters et Setters pour chaque attribut

    // Constructeur par défaut
    public CommandesBeanModele() {
    }

    // Constructeur avec tous les attributs
    public CommandesBeanModele(int id, int id_client, String clients, double montant, Date date_commande) {
        this.id = id;
        this.id_client = id_client;
        this.clients = clients;
        this.montant = montant;
        this.date_commande = date_commande;
    }

    // Getters et Setters pour chaque attribut
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }
}