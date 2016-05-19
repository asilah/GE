package org.gestion.emp.models;

import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;

public class DepartementForm {
	
	private Long codeDept;
	private String nom;
	private String ville;
	private String description;
	private Long chefDept;
	private String submit;
	
	
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	private Departement departement;

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

	public Long getChefDept() {
		return chefDept;
	}

	public void setChefDept(Long chefDept) {
		this.chefDept = chefDept;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	
}
