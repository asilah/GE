package org.gestion.emp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Configurable;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=4)
public class gestion_presence implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeGestion;
	@Temporal(TemporalType.DATE)
	private Date dateGestion;
	private String raison;
	@Temporal(TemporalType.TIME)
	private Date heureDebut;
	@Temporal(TemporalType.TIME)
	private Date heureFin;
	private String etat;
	private int heureSup1;
	private int heureSup2;
	private int heureSup3;
	private int heureRetard;
	@JoinColumn(name="codeEmploye")
	@ManyToOne
	private Employe employe;
	
	
	public gestion_presence() {
		super();
	}
	
	
	public gestion_presence(Date dateGestion, String raison, Employe employe) {
		super();
		this.dateGestion = dateGestion;
		this.raison = raison;
		this.employe = employe;
	}


	public Long getCodeGestion() {
		return codeGestion;
	}
	public void setCodeGestion(Long codeGestion) {
		this.codeGestion = codeGestion;
	}
	public Date getDateGestion() {
		return dateGestion;
	}
	public void setDateGestion(Date dateGestion) {
		this.dateGestion = dateGestion;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public int getHeureRetard() {
		return heureRetard;
	}
	public void setHeureRetard(int heureRetard) {
		this.heureRetard = heureRetard;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getHeureSup1() {
		return heureSup1;
	}
	public void setHeureSup1(int heureSup1) {
		this.heureSup1 = heureSup1;
	}
	public int getHeureSup2() {
		return heureSup2;
	}
	public void setHeureSup2(int heureSup2) {
		this.heureSup2 = heureSup2;
	}
	public int getHeureSup3() {
		return heureSup3;
	}
	public void setHeureSup3(int heureSup3) {
		this.heureSup3 = heureSup3;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	

}
