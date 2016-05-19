package org.gestion.emp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.gestion.emp.models.DepartementForm;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class Departement implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeDept;
	
	
	@NotNull( message= "veuillez saisir le Nom " )
	@Size(min = 1)
	private String nom;
	@Size(min = 1)
	private String ville;
	@Size(min = 10, message= "minimum 10 caracteres ")
	private String description;
	@OneToOne
	private Employe chefDept;
	@OneToMany(mappedBy="departement")
	private Collection<Employe> emplyes;
	
	
	
	public Departement() {
		super();
	}
	public Departement(String nom, String ville, String description, Employe chefDept) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.description = description;
		this.chefDept = chefDept;
	}
	public Long getCodeDept() {
		return codeDept;
	}
	public void setCodeDept(Long codeDept) {
		this.codeDept = codeDept;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Employe getChefDept() {
		return chefDept;
	}
	public void setChefDept(Employe chefDept) {
		this.chefDept = chefDept;
	}
	public Collection<Employe> getEmplyes() {
		return emplyes;
	}
	public void setEmplyes(Collection<Employe> emplyes) {
		this.emplyes = emplyes;
	}
	
	public void affect(Departement d){
		this.nom = d.getNom();
		this.ville = d.getVille();
		this.description = d.getDescription();
		this.chefDept = d.getChefDept();	
	}
	public void affect(DepartementForm d){
		this.nom = d.getNom();
		this.ville = d.getVille();
		this.description = d.getDescription();
		Employe cd = new Employe();
		cd.setCodeEmp(d.getChefDept());
		this.chefDept = cd;	
	}
	
	
	

}
