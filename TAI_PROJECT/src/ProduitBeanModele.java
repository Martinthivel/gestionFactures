public class ProduitBeanModele {
    private int id;
    private String designation;
    private String ref;
    private double prix;

    public ProduitBeanModele() {
        // Constructeur par défaut sans arguments
    }

    public ProduitBeanModele(int id, String designation, String ref, double prix) {
        this.id = id;
        this.designation = designation;
        this.ref = ref;
        this.prix = prix;
    }

    // Getters et Setters pour chaque attribut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
