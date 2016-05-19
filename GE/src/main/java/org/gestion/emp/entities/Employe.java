package org.gestion.emp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.gestion.emp.models.EmployeForm;

@Entity
public class Employe implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmp;
	@Column(unique=true)
	private String cin;
	@Column(unique=true)
	private String numCnss;
	@Size(min = 1)
	private String nom;
	private String prenom;
	@Lob
	private byte[] photo;
	private String sex;
	private String situationFamiliale;
	private int nbEnfant;
	private String ville;
	private String address;
	private String tel;
	private String mail;
	@ManyToOne
	private Employe employeSup;
	private String banque;
	private String numCompteBanque;
	private double salBase;
	private int nbJoursTravail;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String lieuNaissance;
	@Temporal(TemporalType.DATE)
	private Date dateEntre;
	private String responsabilite;
	private boolean active;
	private boolean conge;
	@ManyToOne
	private Departement departement;
	@OneToMany(mappedBy="employe")
	private Collection<gestion_presence> gestion_presences;
	
	
	
	public Employe() {
		super();
	}
	
	public Employe(String cin, String numCnss, String nom, String prenom, byte[] photo, String sex,
			String situationFamiliale, int nbEnfant, String ville, String address, String tel, String mail,
			Employe employeSup, String banque, String numCompteBanque, double salBase, int nbJoursTravail, 
			Date dateNaissance, String lieuNaissance, Date dateEntre, String responsabilite, Departement departement) {
		super();
		this.cin = cin;
		this.numCnss = numCnss;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.sex = sex;
		this.situationFamiliale = situationFamiliale;
		this.nbEnfant = nbEnfant;
		this.ville = ville;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.employeSup = employeSup;
		this.banque = banque;
		this.numCompteBanque = numCompteBanque;
		this.salBase = salBase;
		this.nbJoursTravail = nbJoursTravail;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.dateEntre = dateEntre;
		this.responsabilite = responsabilite;
		this.active = true;
		this.conge = false;
		this.departement = departement;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
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
	public Employe getEmployeSup() {
		return employeSup;
	}

	public void setEmployeSup(Employe employeSup) {
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
	public int getNbJoursTravail() {
		return nbJoursTravail;
	}
	public void setNbJoursTravail(int nbJoursTravail) {
		this.nbJoursTravail = nbJoursTravail;
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
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Collection<gestion_presence> getGestion_presences() {
		return gestion_presences;
	}
	public void setGestion_presences(Collection<gestion_presence> gestion_presences) {
		this.gestion_presences = gestion_presences;
	}
	
	public void affect(Employe e){
		this.cin = e.getCin();
		this.numCnss = e.getNumCnss();
		this.nom = e.getNom();
		this.prenom = e.getPrenom();
		this.photo = e.getPhoto();
		this.sex = e.getSex();
		this.situationFamiliale = e.getSituationFamiliale();
		this.nbEnfant = e.getNbEnfant();
		this.ville = e.getVille();
		this.address = e.getAddress();
		this.tel = e.getTel();
		this.mail = e.getMail();
		this.employeSup = e.getEmployeSup();
		this.banque = e.getBanque();
		this.numCompteBanque = e.getNumCompteBanque();
		this.salBase = e.getSalBase();
		this.nbJoursTravail = e.getNbJoursTravail();
		this.dateNaissance = e.getDateNaissance();
		this.lieuNaissance = e.getLieuNaissance();
		this.dateEntre = e.getDateEntre();
		this.responsabilite = e.getResponsabilite();
		this.active = e.isActive();
		this.conge = e.isConge();
		this.departement = e.getDepartement();
	}
	public void affect(EmployeForm e){
		this.cin = e.getCin();
		this.numCnss = e.getNumCnss();
		this.nom = e.getNom();
		this.prenom = e.getPrenom();
//		this.photo = e.getPhoto();
//		this.sex = e.getSex();
		this.situationFamiliale = e.getSituationFamiliale();
		this.nbEnfant = e.getNbEnfant();
		this.ville = e.getVille();
		this.address = e.getAddress();
		this.tel = e.getTel();
		this.mail = e.getMail();
//		this.nbJoursTravail = e.getNbJoursTravail();
//		
//		if (e.getEmployeSup()!=null) {
//			Employe es = new Employe();
//			es.setCodeEmp(e.getEmployeSup());
//			this.employeSup = es;
//		}
		
		this.banque = e.getBanque();
		this.numCompteBanque = e.getNumCompteBanque();
		this.salBase = e.getSalBase();
//		
//		this.dateNaissance = e.getDateNaissance();
//		this.lieuNaissance = e.getLieuNaissance();
//		this.dateEntre = e.getDateEntre();
		this.responsabilite = e.getResponsabilite();
		Departement d = new Departement();
		d.setCodeDept(e.getDepartement());
		this.departement = d;
	}
	
	

	
}
