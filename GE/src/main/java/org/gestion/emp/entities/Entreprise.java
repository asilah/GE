package org.gestion.emp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.gestion.emp.models.EntrepriseForm;
@Entity
public class Entreprise implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@Lob
	private byte[] logo;
		
	public Entreprise() {
		super();
	}
	
	public Entreprise(String nom, String ville, String address, String tel, String fax, String banque,
			String numCompteBanque, double smig, int heureNormale, byte[] logo) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.address = address;
		this.tel = tel;
		this.fax = fax;
		this.banque = banque;
		this.numCompteBanque = numCompteBanque;
		this.smig = smig;
		this.heureNormale = heureNormale;
		this.logo = logo;
	}
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
	
	public void affect(Entreprise e){
		this.nom = e.getNom();
		this.ville = e.getVille();
		this.address = e.getAddress();
		this.tel = e.getTel();
		this.fax = e.getFax();
		this.banque = e.getBanque();
		this.numCompteBanque = e.getNumCompteBanque();
		this.smig = e.getSmig();
		this.logo = e.getLogo();
	}
	public void affect(EntrepriseForm e){
		this.codeEntrp = 1L;
		this.nom = e.getNom();
		this.ville = e.getVille();
		this.address = e.getAddress();
		this.tel = e.getTel();
		this.fax = e.getFax();
		this.banque = e.getBanque();
		this.numCompteBanque = e.getNumCompteBanque();
		this.smig = e.getSmig();
		this.logo = e.getLogo();
	}


}
