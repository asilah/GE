package model;

import java.util.ArrayList;
import java.util.List;

import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Employe;

public class JournalPaieModel {
	
	private String Cnss;
	private String Cin;
	private String nom;
	private String prenom;
	private double jourTravail;
	private int nbJourTravail;
	private double heureSup;
	private int nbHeureSup;
	private double salBase;
	private double  Anciennete;
	private int perAnciennete;
	private double SalBrute;
	private double cotCNSS;
	private double coteAMO;
	private double SalNet;
	public String getCnss() {
		return Cnss;
	}
	public void setCnss(String cnss) {
		Cnss = cnss;
	}
	public String getCin() {
		return Cin;
	}
	public void setCin(String cin) {
		Cin = cin;
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
	public double getJourTravail() {
		return jourTravail;
	}
	public void setJourTravail(double jourTravail) {
		this.jourTravail = jourTravail;
	}
	public int getNbJourTravail() {
		return nbJourTravail;
	}
	public void setNbJourTravail(int nbJourTravail) {
		this.nbJourTravail = nbJourTravail;
	}
	public double getHeureSup() {
		return heureSup;
	}
	public void setHeureSup(double heureSup) {
		this.heureSup = heureSup;
	}
	public int getNbHeureSup() {
		return nbHeureSup;
	}
	public void setNbHeureSup(int nbHeureSup) {
		this.nbHeureSup = nbHeureSup;
	}
	public double getSalBase() {
		return salBase;
	}
	public void setSalBase(double salBase) {
		this.salBase = salBase;
	}
	public double getAnciennete() {
		return Anciennete;
	}
	public void setAnciennete(double anciennete) {
		Anciennete = anciennete;
	}
	public int getPerAnciennete() {
		return perAnciennete;
	}
	public void setPerAnciennete(int perAnciennete) {
		this.perAnciennete = perAnciennete;
	}
	public double getSalBrute() {
		return SalBrute;
	}
	public void setSalBrute(double salBrute) {
		SalBrute = salBrute;
	}
	public double getCotCNSS() {
		return cotCNSS;
	}
	public void setCotCNSS(double cotCNSS) {
		this.cotCNSS = cotCNSS;
	}
	public double getCoteAMO() {
		return coteAMO;
	}
	public void setCoteAMO(double coteAMO) {
		this.coteAMO = coteAMO;
	}
	public double getSalNet() {
		return SalNet;
	}
	public void setSalNet(double salNet) {
		SalNet = salNet;
	}
	public JournalPaieModel() {
		super();
		// TODO Auto-generated constructor stub
		Cnss="BBXXXXX";
		Cin="XXXXXXX";
		nom="BENNANI";
		prenom="MOHAMMED";
		nbJourTravail=0;
		jourTravail=0.0;
		nbHeureSup=0;
		heureSup=0.0;
		salBase=0.0;
		perAnciennete=0;
		Anciennete=0.0;
		SalBrute=0.0;
		cotCNSS=0.0;
		coteAMO=0;
		SalNet =0;
	}
	public JournalPaieModel(String cnss, String cin, String nom, String prenom,
			double salBase, double salBrute, double salNet) {
		super();
		Cnss = "cnss";
		Cin = "cin";
		this.nom = nom;
		this.prenom = prenom;
		this.salBase = salBase;
		SalBrute = salBrute;
		cotCNSS=salBase*0.0448;
		coteAMO=salBrute*0.02;
		SalNet = salBrute*0.9352;
	}
	
	public JournalPaieModel(BulletinPaie b){
			super();
		
			Employe e=b.getEmploye();
			Cnss=e.getNumCnss();
			Cin= e.getCin();
			nom=e.getNom();
			prenom=e.getPrenom();
			nbJourTravail=e.getNbJoursTravail();
			jourTravail=e.getSalBase()*nbJourTravail;
			nbHeureSup=b.getHeureSup1()+b.getHeureSup2()+b.getHeureSup3();
			heureSup=1.25*b.getHeureSup1()+1.5*b.getHeureSup2()+2*b.getHeureSup3();
			salBase=e.getSalBase()*nbJourTravail;
			perAnciennete=b.getAnciennete();
			Anciennete=salBase*perAnciennete/100;
			SalBrute=salBase+Anciennete;
			cotCNSS=SalBrute*0.0448;
			coteAMO=SalBrute*0.02;
			SalNet =SalBrute-coteAMO-cotCNSS;
		
		
	}
	

	
	public JournalPaieModel Total(List<JournalPaieModel> l){
		JournalPaieModel t= new JournalPaieModel();
		for (JournalPaieModel e : l) {
			t.setJourTravail(t.getJourTravail()+e.getJourTravail());
			t.setHeureSup(t.getHeureSup()+e.getHeureSup());
			t.setAnciennete(t.getAnciennete()+e.getAnciennete());
			t.setSalBase(t.getSalBase()+e.getSalBase());
			t.setSalBrute(t.getSalBrute()+e.getSalBrute());
			t.setCotCNSS(t.getCotCNSS()+e.getCotCNSS());
			t.setCoteAMO(t.getCoteAMO()+e.getCoteAMO());
			t.setSalNet(t.getSalNet()+e.getSalNet());
		}
		
		return t;	
	}
	
	public List<JournalPaieModel> Demo(int taille){
		List<JournalPaieModel> a= new ArrayList<JournalPaieModel>();
		for(int i=0; i<=taille; i++)
		a.add(new JournalPaieModel());
		return a;
	}

	
}


