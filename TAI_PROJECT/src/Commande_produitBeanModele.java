public class Commandes_produitBeanModele {
    private int id;
    private int idCommande;
    private int idProduit;
    private int quantite;

    public Commandes_produitBeanModele() {
        // Constructeur par défaut sans arguments
    }

    public Commandes_produitBeanModele(int id, int idCommande, int idProduit, int quantite) {
        this.id = id;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
    }

    // Getters et Setters pour chaque attribut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}