package org.gestion.emp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.gestion.emp.models.AdminForm;
@Entity
public class Admin implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeAdmin;
	
	private String nom;
	@Column(unique=true)
	private String login;
	@Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
	private String mail;
	private String motpass;
	
	
	
	public Admin() {
		super();
	}
	
	public Admin(String nom, String login, String mail, String motpass) {
		super();
		this.nom = nom;
		this.login = login;
		this.mail = mail;
		this.motpass = motpass;
	}
	public Long getCodeAdmin() {
		return codeAdmin;
	}
	public void setCodeAdmin(Long codeAdmin) {
		this.codeAdmin = codeAdmin;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMotpass() {
		return motpass;
	}
	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}
	
	public void affect(Admin a){
		this.nom = a.getNom();
		this.login = a.getLogin();
		this.mail = a.getMail();
		this.motpass = a.getMotpass();
	}
	public void affect(AdminForm a){
		this.nom = a.getNom();
		this.login = a.getLogin();
		this.mail = a.getMail();
		this.motpass = a.getMotpass();
	}
	
}
