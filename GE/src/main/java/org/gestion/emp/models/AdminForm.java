package org.gestion.emp.models;

import org.gestion.emp.entities.Admin;
import org.gestion.emp.entities.Employe;

public class AdminForm {
	private String login;
	private String motpass;
	private String nom;
	private String mail;
	
	private String exception;
	private String submit;
	private Employe employe;
	private Admin admin;
	
	
	public String getMotpass() {
		return motpass;
	}
	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

}
