public class facture_commande_produitBeanModele {
    private int idFacture;
    private int idCommandeProduit;

    public facture_commande_produitBeanModele() {
        // Constructeur par défaut sans arguments
    }

    public facture_commande_produitBeanModele(int idFacture, int idCommandeProduit) {
        this.idFacture = idFacture;
        this.idCommandeProduit = idCommandeProduit;
    }

    // Getters et Setters pour chaque attribut

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public int getIdCommandeProduit() {
        return idCommandeProduit;
    }

    public void setIdCommandeProduit(int idCommandeProduit) {
        this.idCommandeProduit = idCommandeProduit;
    }
}
