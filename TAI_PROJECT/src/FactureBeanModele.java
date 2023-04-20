import java.util.Date;

public class FactureBeanModele {
    private int id;
    private Date date;
    private double montant;
    private String statut;

    public FactureBeanModele() {
        // Constructeur par défaut sans arguments
    }

    public FactureBeanModele(int id, Date date, double montant, String statut) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.statut = statut;
    }

    // Getters et Setters pour chaque attribut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}