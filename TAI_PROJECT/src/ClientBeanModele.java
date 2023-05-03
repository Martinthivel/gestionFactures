
public class ClientBeanModele {
	private int id;
	private String nom;
	private String adresse_numero;
	private String adresse_voie;
	private String adresse_cp;
	private String adresse_ville;
	private String email;
	private String tel;
	
	//Constructeur vide
	public ClientBeanModele() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String getAdresse_num() {
		return adresse_numero;
	}
	
	public void setAdresse_num(String adresse_numero){
		this.adresse_numero = adresse_numero;
	}
		
	public String getAdresse_voie() {
			return adresse_voie;
		}
		
	public void setAdresse_voie(String adresse_voie){
			this.adresse_voie = adresse_voie;
		}
	
	public String getAdresse_cp() {
		return adresse_cp;
	}
	
	public void setAdresse_cp(String adresse_cp){
		this.adresse_cp = adresse_cp;
	}

	public String getAdresse_ville() {
	return adresse_ville;
	}

	public void setAdresse_ville(String adresse_ville){
	this.adresse_ville = adresse_ville;
	}

	public String getEmail() {
	return email;
	}

	public void setEmail(String email){
	this.email = email;
	}

	public String getTel() {
	return tel;
	}

	public void setTel(String tel){
	this.tel = tel;
}

}
	
