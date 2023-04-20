public class employeBeanModele {
    private int id;
    private String nom;
    private String identifiantConnexion;
    private String mdp;
    private String role;

    public employeBeanModele() {
        // Constructeur par défaut sans arguments
    }

    public employeBeanModele(int id, String nom, String identifiantConnexion, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.identifiantConnexion = identifiantConnexion;
        this.mdp = mdp;
        this.role = role;
    }

    // Getters et Setters pour chaque attribut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentifiantConnexion() {
        return identifiantConnexion;
    }

    public void setIdentifiantConnexion(String identifiantConnexion) {
        this.identifiantConnexion = identifiantConnexion;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


