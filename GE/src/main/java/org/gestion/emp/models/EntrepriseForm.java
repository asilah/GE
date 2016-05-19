package org.gestion.emp.models;

import org.gestion.emp.entities.Entreprise;

public class EntrepriseForm {
	private Long codeEntrp;
	private String nom;
	private String ville;
	private String address;
	private String tel;
	private String fax;
	private String banque;
	private String numCompteBanque;
	private double smig;
	private int heureNormale;
	private byte[] logo;
	private String submit;
	
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	private Entreprise entreprise;

	public Long getCodeEntrp() {
		return codeEntrp;
	}

	public void setCodeEntrp(Long codeEntrp) {
		this.codeEntrp = codeEntrp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getNumCompteBanque() {
		return numCompteBanque;
	}

	public void setNumCompteBanque(String numCompteBanque) {
		this.numCompteBanque = numCompteBanque;
	}

	public double getSmig() {
		return smig;
	}

	public void setSmig(double smig) {
		this.smig = smig;
	}

	public int getHeureNormale() {
		return heureNormale;
	}

	public void setHeureNormale(int heureNormale) {
		this.heureNormale = heureNormale;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	
}
