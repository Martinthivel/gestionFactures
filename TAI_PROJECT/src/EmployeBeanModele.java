public class EmployeBeanModele {
    private int id;
    private String nom;
    private String prenom;
    private String identifiantConnexion;
    private String mdp;
    private String role;

    public EmployeBeanModele() {
        // Constructeur par défaut sans arguments
    }

    public EmployeBeanModele(int id, String nom, String prenom, String identifiantConnexion, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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


