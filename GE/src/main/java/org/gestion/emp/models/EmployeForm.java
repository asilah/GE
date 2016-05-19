package org.gestion.emp.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;

public class EmployeForm {
	
	private Long codeEmp;
	@Size(min=6,max=7)
	private String cin;
	@Size(min=9,max=9)
	private String numCnss;
	private String nom;
	private String prenom;
//	private byte[] photo;
	private String sex;
	private String situationFamiliale;
	private int nbEnfant;
	private String ville;
	private String address;
	private String tel;
	private String mail;
	private Long employeSup;
	private String banque;
	private String numCompteBanque;
	private double salBase;
	private int nbJoursTravail;
	
	private Date dateNaissance;
	private String lieuNaissance;
	
	private Long departement;
	private Employe employe;
	
	private Date dateEntre;
	private String responsabilite;
	private boolean active;
	private boolean conge;
	private String submit;
	
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getNbJoursTravail() {
		return nbJoursTravail;
	}
	public void setNbJoursTravail(int nbJoursTravail) {
		this.nbJoursTravail = nbJoursTravail;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isConge() {
		return conge;
	}
	public void setConge(boolean conge) {
		this.conge = conge;
	}
	
	
	
	
	
	public Long getCodeEmp() {
		return codeEmp;
	}
	public void setCodeEmp(Long codeEmp) {
		this.codeEmp = codeEmp;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNumCnss() {
		return numCnss;
	}
	public void setNumCnss(String numCnss) {
		this.numCnss = numCnss;
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
//	public byte[] getPhoto() {
//		return photo;
//	}
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public int getNbEnfant() {
		return nbEnfant;
	}
	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Long getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Long employeSup) {
		this.employeSup = employeSup;
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
	public double getSalBase() {
		return salBase;
	}
	public void setSalBase(double salBase) {
		this.salBase = salBase;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public Date getDateEntre() {
		return dateEntre;
	}
	public void setDateEntre(Date dateEntre) {
		this.dateEntre = dateEntre;
	}
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	public Long getDepartement() {
		return departement;
	}
	public void setDepartement(Long departement) {
		this.departement = departement;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
